package it.unibo.oop.lab.nesting2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.oop.lab.nesting2.Acceptor.ElementNotAcceptedException;
import it.unibo.oop.lab.nesting2.Acceptor.EndNotAcceptedException;

public class OneListAcceptable<T> implements Acceptable<T> {

	private List<T> acceptableList;
	private Set<T> acceptatedSet;
	
	/**
	 * Builds new {@link OneListAcceptable} and sets acceptable list sequence
	 * 
	 * @param acceptableList
	 * 							acceptable list sequence to be set
	 * */
	public OneListAcceptable(List<T> acceptableList) {
		this.acceptableList = acceptableList;
		this.acceptatedSet = new HashSet<>();
	}
	
	/**
	 * Defines and returns a new acceptor which works with a list sequence
	 * 
	 * @return {@link Acceptor}
	 * 							which accepts only items stored into acceptable list
	 * 							and when accepted items are the same than expected items, it ends input
	 * 
	 * @throws ElementNotAcceptedException
	 * 										if the element is not expected
	 * 
	 * @throws EndNotAcceptedException
	 * 									if cannot ends input
	 * */
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
