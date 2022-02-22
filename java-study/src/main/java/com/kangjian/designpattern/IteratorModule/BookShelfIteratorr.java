package com.kangjian.designpattern.IteratorModule;

/**
 *  具体的迭代器
 */

public class BookShelfIteratorr implements Iteratorr<Book> {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIteratorr(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (bookShelf.getLength() > index){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        Book book =  bookShelf.getBookAt(index);
        index ++;
        return book;
    }
}
