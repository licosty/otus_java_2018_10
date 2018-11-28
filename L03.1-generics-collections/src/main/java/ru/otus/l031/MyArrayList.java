package ru.otus.l031;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ARRAY = new Object[0];
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = DEFAULT_CAPACITY_EMPTY_ARRAY;
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else {
            if (capacity != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + capacity);
            }

            this.elements = DEFAULT_CAPACITY_EMPTY_ARRAY;
        }
    }

    public MyArrayList(Collection<? extends T> var1) {
        this.elements = var1.toArray();
        if ((this.size = this.elements.length) != 0) {
            if (this.elements.getClass() != Object[].class) {
                this.elements = Arrays.copyOf(this.elements, this.size, Object[].class);
            }
        } else {
            this.elements = DEFAULT_CAPACITY_EMPTY_ARRAY;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported");
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean add(T t) {
        int var1 = size + 1;
        if (this.elements == DEFAULT_CAPACITY_EMPTY_ARRAY) {
            var1 = Math.max(10, var1);
        }

        if (var1 - this.elements.length > 0) {
            if (var1 > 10) {
                var1 *= 2;
            }
            this.elements = Arrays.copyOf(this.elements, var1);
        }
        this.elements[this.size++] = t;
        return true;
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported");
    }

    public void clear() {

    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (T) this.elements[index];
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T var1 = (T) elements[index];
        this.elements[index] = element;
        return var1;
    }

    public void add(int index, T element) {
        throw new UnsupportedOperationException("Not supported");
    }

    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported");
    }

    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported");
    }

    public ListIterator<T> listIterator() {
        return new MyIterator(0);
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported");
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    private class MyIterator implements ListIterator<T> {

        private static final int LAST_IS_NOT_SET = -1;
        private int index;
        private int lastIndex = -1;

        public MyIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return MyArrayList.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastIndex = index++;
            return (T) MyArrayList.this.elements[lastIndex];
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public T previous() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public void set(T t) {
            if (lastIndex != LAST_IS_NOT_SET) {
                MyArrayList.this.set(lastIndex, t);
                lastIndex = LAST_IS_NOT_SET;
            } else
                throw new IllegalStateException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException("Not supported");
        }
    }


}
