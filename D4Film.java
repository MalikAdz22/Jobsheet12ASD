public class D4Film {
    NodeFilm head;
    int size;

    public D4Film() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Film17 item) {
        if (isEmpty()) {
            head = new NodeFilm(null, item, null);
        } else {
            NodeFilm newNode = new NodeFilm(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }

    public void addlast(Film17 item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            NodeFilm current = head;
            while (current.next != null) {
                current = current.next;
            }

            NodeFilm newNode = new NodeFilm(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(Film17 item, int index) throws Exception {
        if (isEmpty()) {
            addFirst(item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            NodeFilm current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            if (current.prev == null) {
                NodeFilm newNode = new NodeFilm(null, item, current);
                current.prev = newNode;
                head = newNode;
            } else {
                NodeFilm newNode = new NodeFilm(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            NodeFilm tmp = head;
            System.out.println("Cetak Data");
            while (tmp != null) {
                System.out.println("ID \t: " +tmp.data.id);
                System.out.println("  Judul \t: " +tmp.data.judul);
                System.out.println("  Rating \t: " +tmp.data.rating);
                tmp = tmp.next;
            }
            // System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        NodeFilm current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            NodeFilm current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }

            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public Film17 getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public Film17 getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        NodeFilm tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Film17 get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        NodeFilm tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public Film17 searchById(int id) throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong");
        }

        NodeFilm current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }

        throw new Exception("Film dengan ID " + id + " tidak ditemukan");
    }

    public void sortByRatingDesc() {
        if (isEmpty() || size == 1) {
            return; 
        }

        for (int i = 0; i < size - 1; i++) {
            NodeFilm current = head;
            NodeFilm maxNode = current;

            for (int j = 0; j < size - i - 1; j++) {
                if (current.next != null && current.next.data.rating > maxNode.data.rating) {
                    maxNode = current.next;
                }
                current = current.next;
            }

            if (maxNode != current) {
                Film17 temp = current.data;
                current.data = maxNode.data;
                maxNode.data = temp;
            }
        }
    }
}
