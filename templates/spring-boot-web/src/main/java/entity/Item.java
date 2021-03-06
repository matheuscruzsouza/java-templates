package ${pkg}.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Item implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;

  private String name;

  private Category category;

  public Item() { 
    // construct default 
  }

  public Item(final String name, final Category category) { 
    this.name = name;
    this.category = category;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setId(final String id) {
    this.id = Integer.parseInt(id);
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setCategory(final Category category) {
    this.category = category;
  }

  @ManyToOne
  @JoinColumn
  @JsonBackReference
  public Category getCategory() {
    return this.category;
  }

}
