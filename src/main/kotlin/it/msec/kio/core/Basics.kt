package it.msec.kio.core

fun <A> identity(a: A) = a

inline infix fun <A, B, C> ((B) -> C).compose(crossinline f: (A) -> B): (A) -> C = { a -> this(f(a)) }
inline infix fun <A, B, C> ((A) -> B).andThen(crossinline f: (B) -> C): (A) -> C = { a -> f(this(a)) }

fun <A, B, C> ((A, B) -> C).curried() = { a: A -> { b: B -> invoke(a, b) } }
fun <A, B, C, D> ((A, B, C) -> D).curried() = { a: A -> { b: B -> { c: C -> invoke(a, b, c) } } }

fun <A, B> A?.then(f: (A) -> B) = this?.let(f)
fun <A> A?.getOrElse(a: A) = this ?: a
fun <A> A?.getOrElse(f: () -> A) = this ?: f()
