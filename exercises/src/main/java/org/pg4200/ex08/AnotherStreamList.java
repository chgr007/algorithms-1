package org.pg4200.ex08;

import org.pg4200.les08.iterator.MyIterableLinkedList;
import org.pg4200.les08.stream.MyStream;
import org.pg4200.les08.stream.MyStreamCollectionList;
import org.pg4200.les08.stream.MyStreamSupport;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class AnotherStreamList<T> extends MyIterableLinkedList<T> {

    public AnotherStream<T> stream() {
        return AnotherStreamSupport.createStream(this);
    }

}
