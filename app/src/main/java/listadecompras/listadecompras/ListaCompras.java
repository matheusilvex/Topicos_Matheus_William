package listadecompras.listadecompras;

/**
 * Created by matheuswilliamoliveira on 9/27/17.
 */

public class ListaCompras {
    private String produto;
    private String quantidade;
    private boolean perecivel;
    private String categoria;

    public ListaCompras(String produto, String quantidade, boolean perecivel, String categoria) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.perecivel = perecivel;
        this.categoria = categoria;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
