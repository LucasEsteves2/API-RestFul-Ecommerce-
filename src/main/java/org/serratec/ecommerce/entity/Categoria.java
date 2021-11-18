package org.serratec.ecommerce.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria", schema = "public")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    
    @NotBlank
    @Size(max=30)
    @Column(name = "nome",  length = 30, nullable = true)
    private String nome;
    
    @NotBlank
    @Size(max=150)
    @Column(name = "descricao",  length = 150, nullable = true)
    private String descricao;
    
    @OneToMany (mappedBy = "categoria")
    private List<Produto>produto = new ArrayList<>();

    
    public Categoria() {
        super();
    }

    public Categoria(Integer id_categoria, @NotBlank @Size(max = 30) String nome,
            @NotBlank @Size(max = 150) String descricao, List<Produto> produto) {
        this.id_categoria = id_categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.produto = produto;
    }
    
    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        return Objects.equals(id_categoria, other.id_categoria);
    }

    @Override
    public String toString() {
        return "Categoria [id_categoria=" + id_categoria + ", nome=" + nome + ", descricao=" + descricao + ", produto="
                + produto + "]";
    }

    
}