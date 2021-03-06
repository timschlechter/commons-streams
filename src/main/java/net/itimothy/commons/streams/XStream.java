package net.itimothy.commons.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class XStream<T> extends XBaseStream<T, XStream<T>> implements Stream<T> {

    private final Stream<T> stream;
    
    private XStream(Stream<T> stream) {
        this.stream = stream;
    }

    public static <T> XStream<T> wrap(Stream<T> stream) {
        return new XStream(stream);
    }

    @Override
    public Object[] toArray() {
        return stream.toArray();
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        return stream.min(comparator);
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        return stream.max(comparator);
    }

    @Override
    public Optional<T> findFirst() {
        return stream.findFirst();
    }

    @Override
    public Optional<T> findAny() {
        return stream.findAny();
    }
    
    @Override
    protected XStream<T> createInstance(Stream<T> stream) {
        return StreamUtils.stream(stream);
    }

    @Override
    public XStream<T> boxed() {
        return this;
    }

    @Override
    public XStream<T> filter(Predicate<? super T> predicate) {
        return wrap(stream.filter(predicate));
    }

    @Override
    public <R> XStream<R> map(Function<? super T, ? extends R> mapper) {
        return wrap(stream.map(mapper));
    }

    @Override
    public XIntStream mapToInt(ToIntFunction<? super T> mapper) {
        return XIntStream.wrap(stream.mapToInt(mapper));
    }

    @Override
    public XLongStream mapToLong(ToLongFunction<? super T> mapper) {
        return XLongStream.wrap(stream.mapToLong(mapper));
    }

    @Override
    public XDoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return XDoubleStream.wrap(stream.mapToDouble(mapper));
    }

    @Override
    public <R> XStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return wrap(stream.flatMap(mapper));
    }

    @Override
    public XIntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return XIntStream.wrap(stream.flatMapToInt(mapper));
    }

    @Override
    public XLongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return XLongStream.wrap(stream.flatMapToLong(mapper));
    }

    @Override
    public XDoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return XDoubleStream.wrap(stream.flatMapToDouble(mapper));
    }

    @Override
    public Optional<T> first() {
        return findFirst();
    }

    @Override
    public XStream<T> distinct() {
        return wrap(stream.distinct());
    }

    @Override
    public XStream<T> sorted() {
        return wrap(stream.sorted());
    }

    @Override
    public XStream<T> sorted(Comparator<? super T> comparator) {
        return wrap(stream.sorted(comparator));
    }

    @Override
    public XStream<T> peek(Consumer<? super T> action) {
        return wrap(stream.peek(action));
    }

    @Override
    public XStream<T> limit(long maxSize) {
        return wrap(stream.limit(maxSize));
    }

    @Override
    public XStream<T> skip(long n) {
        return wrap(stream.skip(n));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        stream.forEach(action);
    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        stream.forEachOrdered(action);
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        return stream.toArray(generator);
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream.reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return stream.reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return stream.reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return stream.collect(collector);
    }

    @Override
    public long count() {
        return stream.count();
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream.anyMatch(predicate);
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        return stream.allMatch(predicate);
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream.noneMatch(predicate);
    }

    @Override
    public Iterator<T> iterator() {
        return stream.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return stream.spliterator();
    }

    @Override
    public boolean isParallel() {
        return stream.isParallel();
    }

    @Override
    public XStream<T> sequential() {
        return wrap(stream.sequential());
    }

    @Override
    public XStream<T> parallel() {
        return wrap(stream.parallel());
    }

    @Override
    public XStream<T> unordered() {
        return wrap(stream.unordered());
    }

    @Override
    public XStream<T> onClose(Runnable closeHandler) {
        return wrap(stream.onClose(closeHandler));
    }

    @Override
    public void close() {
        stream.close();
    }
}
