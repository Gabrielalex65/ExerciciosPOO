import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {
	
	private ObservableList<Aluno> lista = FXCollections.observableArrayList();
	
	private LongProperty id = new SimpleLongProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty ra = new SimpleStringProperty();
	private ObjectProperty<LocalDate> nascimento = 
			new SimpleObjectProperty<>(LocalDate.now());
	
	public Aluno getAluno() { 
		Aluno a = new Aluno();
		a.setId(this.id.get());
		a.setNome(this.nome.get());
		a.setRa(this.ra.get());
		a.setNascimento(this.nascimento.get());
		return a;
	}
	
	public void setAluno(Aluno a) { 
		if (a != null) {
			this.id.set(a.getId());
			this.nome.set(a.getNome());
			this.ra.set(a.getRa());
			this.nascimento.set(a.getNascimento());
		}
	}
	
	public void adicionar() {
//		Contato c = getContato();
//		lista.add( c );
		
		lista.add(getAluno());
	}
	
	public void pesquisarPorNome() { 
		String txt = this.nome.get();
		for (Aluno a : lista) { 
			if (a.getNome().contains(txt)) { 
				setAluno(a);
			}
		}
	}

	public LongProperty getIdProperty() {
		return id;
	}
	public StringProperty getNomeProperty() {
		return nome;
	}
	public StringProperty getRaProperty() {
		return ra;
	}
	public ObjectProperty<LocalDate> getNascimentoProperty() {
		return nascimento;
	}
	public ObservableList<Aluno> getLista() { 
		return lista;
	}
}
