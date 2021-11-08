package it.unibo.oop.lab.nesting2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> acceptableList;
	private Set<T> acceptatedSet;
	
	public OneListAcceptable(List<T> acceptableList) {
		this.acceptableList = acceptableList;
		this.acceptatedSet = new HashSet<>();
	}
	
	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T> () {

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if(OneListAcceptable.this.acceptableList.contains(newElement)) {
					acceptatedSet.add(newElement);
				} else {
					throw new ElementNotAcceptedException(newElement);
				}
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if(OneListAcceptable.this.acceptableList.size() != acceptatedSet.size()) {
					throw new EndNotAcceptedException();
				}
			}
			
		};
	}

}
