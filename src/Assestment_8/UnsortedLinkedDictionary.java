package Assestment_8;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V>  implements DictionaryInterface<K, V> {
	private Node firstNode;
	private int numberOfEntries;

	public UnsortedLinkedDictionary() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

   public V add(K key, V value) {
	   if (key == null || value == null) {
		   throw new IllegalArgumentException("Key or value cannot be null.");
	   }

	   // Search for key in chain
	   Node currentNode = firstNode;
	   while (currentNode != null) {
		   if (key.equals(currentNode.getKey())) {
			   // Key already exists, update value and return old value
			   V oldValue = currentNode.getValue();
			   currentNode.setValue(value);
			   return oldValue;
		   }
		   currentNode = currentNode.getNextNode();
	   }

	   // Key not found, add new node at beginning of chain
	   Node newNode = new Node(key, value);
	   newNode.setNextNode(firstNode);
	   firstNode = newNode;
	   numberOfEntries++;
	   return null; // No old value to return
   } // end add

   public V remove(K key) {
	   if (key == null) {
		   throw new IllegalArgumentException("Key cannot be null.");
	   }

	   V result = null;

	   if (!isEmpty()) {
		   if (key.equals(firstNode.getKey())) {
			   // Key is in first node
			   result = firstNode.getValue();
			   firstNode = firstNode.getNextNode();
			   numberOfEntries--;
		   } else {
			   // Key is in some other node
			   Node prevNode = firstNode;
			   Node currentNode = firstNode.getNextNode();
			   while (currentNode != null) {
				   if (key.equals(currentNode.getKey())) {
					   // Key found, remove node
					   result = currentNode.getValue();
					   prevNode.setNextNode(currentNode.getNextNode());
					   numberOfEntries--;
					   break;
				   }
				   prevNode = currentNode;
				   currentNode = currentNode.getNextNode();
			   }
		   }
	   }

	   return result;
   } // end remove

   public V getValue(K key) {
	   if (key == null) {
		   throw new IllegalArgumentException("Key cannot be null.");
	   }

	   Node currentNode = firstNode;
	   while (currentNode != null) {
		   if (key.equals(currentNode.getKey())) {
			   return currentNode.getValue();
		   }
		   currentNode = currentNode.getNextNode();
	   }

	   return null; // Key not found
   } // end getValue

	public boolean contains(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null.");
		}

		Node currentNode = firstNode;
		while (currentNode != null) {
			if (key.equals(currentNode.getKey())) {
				return true;
			}
			currentNode = currentNode.getNextNode();
		}

		return false; // Key not found
   } // end contains

   public boolean isEmpty() {
	   return numberOfEntries == 0;
   } // end isEmpty

   public int getSize() {
	   return numberOfEntries;
   } // end getSize

	public final void clear() {
		firstNode = null;
		numberOfEntries = 0;
	} // end clear

	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	} // end getKeyIterator

	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	} // end getValueIterator

	private class Node {
		private K key;
		private V value;
		private Node next;

		private Node(K searchKey, V dataValue) {
			key = searchKey;
			value = dataValue;
			next = null;
		} // end constructor

		private Node(K searchKey, V dataValue, Node nextNode) {
			key = searchKey;
			value = dataValue;
			next = nextNode;
		} // end constructor

		private K getKey() {
			return key;
		} // end getKey

		private V getValue() {
			return value;
		} // end getValue

		private void setValue(V newValue) {
			value = newValue;
		} // end setValue

		private Node getNextNode()
		{
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

	private class KeyIterator implements Iterator<K> {
		private Node currentNode;

		public KeyIterator() {
			currentNode = firstNode;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public K next() {
			if (hasNext()) {
				K currentKey = currentNode.getKey();
				currentNode = currentNode.getNextNode();
				return currentKey;
			} else {
				throw new NoSuchElementException("No more elements.");
			}
		}
	} // end KeyIterator

	private class ValueIterator implements Iterator<V> {
		private Node currentNode;

		public ValueIterator() {
			currentNode = firstNode;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public V next() {
			if (hasNext()) {
				V currentValue = currentNode.getValue();
				currentNode = currentNode.getNextNode();
				return currentValue;
			} else {
				throw new NoSuchElementException("No more elements.");
			}
		}
	} // end ValueIterator
} // end UnsortedLinkedDictionary
		
