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

// Definição da estrutura da pilha
pub struct Stack<T> {
    head: Option<Box<Node<T>>>,
}

// Implementação de métodos para a estrutura Stack
impl<T> Stack<T> {
    // Construtor para criar uma nova pilha vazia
    pub fn new() -> Self {
        Stack { head: None }
    }

    // Método para verificar se a pilha está vazia
    pub fn is_empty(&self) -> bool {
        self.head.is_none()
    }

    // Método para adicionar um elemento no topo da pilha
    pub fn push(&mut self, data: T) {
        let new_node = Box::new(Node::new(data));
        match self.head.take() {
            Some(old_head) => {
                new_node.next = Some(old_head);
                self.head = Some(new_node);
            }
            None => {
                self.head = Some(new_node);
            }
        }
    }

    // Método para remover e retornar o elemento do topo da pilha
    pub fn pop(&mut self) -> Option<T> {
        self.head.take().map(|mut old_head| {
            self.head = old_head.next.take();
            old_head.data
        })
    }

    // Método para obter uma referência para o elemento no topo da pilha
    pub fn peek(&self) -> Option<&T> {
        self.head.as_ref().map(|node| &node.data)
    }
}

fn main() {
    let mut stack: Stack<i32> = Stack::new();

    // Adicionando elementos à pilha
    stack.push(1);
    stack.push(2);
    stack.push(3);

    // Verificando se a pilha está vazia
    println!("A pilha está vazia: {}", stack.is_empty());

    // Acessando o elemento no topo da pilha (sem removê-lo)
    println!("Elemento no topo da pilha: {:?}", stack.peek());

    // Removendo elementos da pilha e imprimindo-os
    while let Some(value) = stack.pop() {
        println!("Elemento removido: {}", value);
    }

    // Verificando novamente se a pilha está vazia
    println!("A pilha está vazia: {}", stack.is_empty());
}
