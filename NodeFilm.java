public class NodeFilm {
    Film17  data;
    NodeFilm prev, next;

    NodeFilm(NodeFilm prev, Film17 data, NodeFilm next)
    {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
