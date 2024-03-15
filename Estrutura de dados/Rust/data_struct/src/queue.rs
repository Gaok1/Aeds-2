// Definição do tipo da estrutura Node (Nó)
struct Node<T> {
    data: T,
    next: Option<Box<Node<T>>>,
}

// Implementação de métodos para a estrutura Node
impl<T> Node<T> {
    // Construtor para criar um novo nó
    fn new(data: T) -> Self {
        Node { data, next: None }
    }
}

// Definição da estrutura da fila
pub struct Queue<T> {
    head: Option<Box<Node<T>>>,
    tail: *mut Node<T>,
}

// Implementação de métodos para a estrutura Queue
impl<T> Queue<T> {
    // Construtor para criar uma nova fila vazia
    pub fn new() -> Self {
        let dummy_node = Box::new(Node::new(Default::default()));
        let dummy_raw = Box::into_raw(dummy_node);
        Queue {
            head: None,
            tail: dummy_raw,
        }
    }

    // Método para verificar se a fila está vazia
    pub fn is_empty(&self) -> bool {
        self.head.is_none()
    }

    // Método para adicionar um elemento no final da fila
    pub fn enqueue(&mut self, data: T) {
        let new_tail = Box::new(Node::new(data));
        let raw_tail: *mut _ = &*new_tail;
        unsafe {
            (*self.tail).next = Some(new_tail);
            self.tail = raw_tail;
        }
        if self.head.is_none() {
            self.head = Some(Box::from_raw(self.tail));
        }
    }

    // Método para remover e retornar o elemento do início da fila
    pub fn dequeue(&mut self) -> Option<T> {
        self.head.take().map(|mut old_head| {
            self.head = old_head.next.take();
            if self.head.is_none() {
                self.tail = std::ptr::null_mut();
            }
            old_head.data
        })
    }

    // Método para obter uma referência para o elemento no início da fila
    pub fn peek(&self) -> Option<&T> {
        self.head.as_ref().map(|node| &node.data)
    }
}

fn main() {
    let mut queue: Queue<i32> = Queue::new();

    // Adicionando elementos à fila
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    // Verificando se a fila está vazia
    println!("A fila está vazia: {}", queue.is_empty());

    // Acessando o elemento no início da fila (sem removê-lo)
    println!("Elemento no início da fila: {:?}", queue.peek());

    // Removendo elementos da fila e imprimindo-os
    while let Some(value) = queue.dequeue() {
        println!("Elemento removido: {}", value);
    }

    // Verificando novamente se a fila está vazia
    println!("A fila está vazia: {}", queue.is_empty());
}
