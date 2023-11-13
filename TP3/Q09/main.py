from http.server import SimpleHTTPRequestHandler
from socketserver import TCPServer
from http.client import HTTPConnection
import threading

class DebuggingHandler(SimpleHTTPRequestHandler):
    def do_GET(self):
        self.print_request()
        super().do_GET()

    def do_POST(self):
        self.print_request()
        super().do_POST()

    def print_request(self):
        print(f"\nReceived {self.command} request from {self.client_address[0]} for {self.path}")
        print("Headers:\n", self.headers)

        content_length = int(self.headers.get('Content-Length', 0))
        if content_length > 0:
            content = self.rfile.read(content_length)
            print("\nRequest body:\n", content.decode('utf-8'))

def run_debugger():
    port = 8080
    server_address = ('', port)

    httpd = TCPServer(server_address, DebuggingHandler)

    print(f"HTTP Debugger running on port {port}")

    try:
        httpd.serve_forever()
    except KeyboardInterrupt:
        pass
    finally:
        httpd.server_close()

def send_test_request():
    while True:
        conn = HTTPConnection('localhost', 8080)
        conn.request("GET", "/test")
        response = conn.getresponse()

        print("\nResponse status:", response.status)
        print("Response headers:\n", response.getheaders())
        print("Response body:\n", response.read().decode('utf-8'))

if __name__ == '__main__':
    # Iniciar o servidor HTTP em uma thread separada
    server_thread = threading.Thread(target=run_debugger)
    server_thread.start()

    # Enviar solicitações de teste em um loop infinito
    send_test_request()
