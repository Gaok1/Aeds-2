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

// Definição da estrutura da lista encadeada
pub struct LinkedList<T> {
    head: Option<Box<Node<T>>>,
}

// Implementação de métodos para a estrutura LinkedList
impl<T> LinkedList<T> {
    // Construtor para criar uma nova lista vazia
    pub fn new() -> Self {
        LinkedList { head: None }
    }

    // Método para adicionar um elemento no início da lista
    pub fn add_first(&mut self, data: T) {
        let new_node = Box::new(Node::new(data));
        new_node.next = self.head.take();
        self.head = Some(new_node);
    }

    // Método para remover e retornar o elemento do final da lista
    pub fn remove_last(&mut self) -> Option<T> {
        if self.head.is_none() {
            return None;
        }

        let mut current_node = self.head.as_mut().unwrap();
        let mut prev_node = None;

        // Percorre a lista até o último nó
        while let Some(ref mut next_node) = current_node.next {
            prev_node = Some(current_node);
            current_node = next_node;
        }

        // Se houver um nó anterior, atualiza sua referência para o próximo nó como None
        if let Some(prev) = prev_node {
            prev.next = None;
        } else {
            self.head = None;
        }

        // Retorna o dado do último nó
        Some(current_node.data)
    }

    // Método para remover e retornar o elemento do início da lista
    pub fn remove_first(&mut self) -> Option<T> {
        self.head.take().map(|mut old_head| {
            self.head = old_head.next.take();
            old_head.data
        })
    }

    // Método para adicionar um elemento no final da lista
    pub fn add_last(&mut self, data: T) {
        let new_node = Box::new(Node::new(data));
        let mut current_node = self.head.as_mut();

        // Percorre a lista até o último nó
        while let Some(node) = current_node {
            if node.next.is_none() {
                node.next = Some(new_node);
                return;
            }
            current_node = node.next.as_mut();
        }

        // Se a lista estiver vazia, o novo nó é o primeiro
        self.head = Some(new_node);
    }

    // Método para adicionar um elemento na posição especificada
    pub fn add_at(&mut self, index: usize, data: T) {
        if index == 0 {
            self.add_first(data);
            return;
        }

        let mut current_index = 0;
        let mut current_node = self.head.as_mut();

        // Percorre a lista até o nó anterior à posição desejada
        while let Some(node) = current_node {
            if current_index + 1 == index {
                let new_node = Box::new(Node::new(data));
                new_node.next = node.next.take();
                node.next = Some(new_node);
                return;
            }
            current_index += 1;
            current_node = node.next.as_mut();
        }

        // Se a posição for maior que o comprimento atual da lista, adiciona no final
        self.add_last(data);
    }

    // Método para remover e retornar o elemento na posição especificada
    pub fn remove_at(&mut self, index: usize) -> Option<T> {
        if index == 0 {
            return self.remove_first();
        }

        let mut current_index = 0;
        let mut current_node = self.head.as_mut();
        let mut prev_node = None;

        // Percorre a lista até o nó na posição desejada
        while let Some(node) = current_node {
            if current_index == index {
                let next_node = node.next.take();
                prev_node.as_mut().unwrap().next = next_node;
                return Some(node.data);
            }
            current_index += 1;
            prev_node = current_node;
            current_node = node.next.as_mut();
        }

        None
    }
}

fn main() {
    let mut list: LinkedList<i32> = LinkedList::new();

    // Adicionando elementos na lista
    list.add_first(3);
    list.add_first(2);
    list.add_first(1);

    // Adicionando elementos no final e na posição específica
    list.add_last(4);
    list.add_at(2, 5);

    // Removendo elementos do início, do final e em uma posição específica
    list.remove_first();
    list.remove_last();
    list.remove_at(1);

    // Imprimindo os elementos restantes na lista
    let mut current_node = list.head.as_ref();
    while let Some(node) = current_node {
        println!("Elemento: {}", node.data);
        current_node = node.next.as_ref();
    }
}
