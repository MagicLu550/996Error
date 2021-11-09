@file:Suppress("VARIABLE_IN_SINGLETON_WITHOUT_THREAD_LOCAL")

package me.heizi.errors.`996`

import kotlin.reflect.KClass

/**
 * 本程序内含996！！
 */
internal interface `996Errors`

/**
 * 当使用DSLTryCatch或Throwing 996Errors时执行[Config996Errors.whenLogOverrode]，你可以重写该方法。
 * 如果开启打印会调用[print]函数打印[word]，不想惹是生非则可关闭或重写[whenLogOverrode]。
 */
object Config996Errors {
    var isPrint = false
    var whenLogOverrode:()->Unit = {
        if (isPrint) {
            println(word)
        } else {
            val word = Config996Errors.word+";在内存中留下痕迹;"
        }
    }
    var word = "该程序由996公司开发"
}

/**
 * Try Catch DSL
 * ### How to use ?
 * ```kotlin
 *  TryCatchDSL996.`try` {
 *      ...
 *  }.catch(...) {
 *      ...
 *  } finally {
 *      ...
 *  } and Done
 *  ```
 */
class TryCatchDSL996 <R>  private  constructor (private val block: () -> R ){

    private var catchs:(MutableList<Pair<KClass<out Throwable>,(Throwable)->Unit>>)? = null
    private var finally:(()->Unit)? = null

    fun <T:Throwable> catch(e:T,block:(T)->Unit):TryCatchDSL996<R> {
        if (catchs==null) catchs = arrayListOf()
        catchs?.add(e::class to block as (Throwable) -> Unit )
        return this
    }

    infix fun finally(block:()->Unit):TryCatchDSL996<R> {
        finally = block
        return this
    }

    operator fun invoke():R? {
        if (catchs==null||catchs!!.isEmpty()) error("Try你***啊Try！！又不Catch！！气死")
        return try {
            Config996Errors.whenLogOverrode()
            block()
        } catch (e:Throwable) {
            for ( (ex,b) in catchs!!) {
                if (e::class == ex) {
                    Config996Errors.whenLogOverrode()
                    b(e)
                }
            }
            null
        } finally {
            finally?.invoke()
        }
    }
    infix fun and(done:Done) = invoke()


    object Done
    companion object {
        /**
         * ```kotlin
         *  TryCatchDSL996.`try` {
         *      ...
         *  }.catch(...) {
         *      ...
         *  } finally {
         *      ...
         *  } and Done
         *  ```
         */
        fun <R> `try`(block: () -> R):TryCatchDSL996<R> = TryCatchDSL996(block)
    }

    //写失败的DSL
//    inner class  CatchContext <T:Throwable>  (val e: T) {
//        fun invoke(block:(T)->Unit):TryCatchDSL996<R> = catch(e,block)
//    }
//    infix fun <T:Throwable> catch(e: T):CatchContext<T> = CatchContext(e)

}




/**
 * 或直接的告诉用户您正在使用的应用的开发者正在996
 *
 * @param message [Throwable.message]
 * @param e [Throwable]
 */
class `996Error` (
    message:String?=null,
    e:Throwable?=null,
) :Error(message,e),`996Errors` {
    init {
        Config996Errors.whenLogOverrode()
    }
}

/**
 * 或直接的告诉用户您正在运行的程序的开发者正在996
 *
 * @param message [Throwable.message]
 * @param e [Throwable]
 */
class `996RuntimeException` (
    message:String?=null,
    e:Throwable?=null,
) :RuntimeException(message,e),`996Errors` {
    init {
        Config996Errors.whenLogOverrode()
    }
}

/**
 * 或直接的告诉其他的开发者这个包By996
 *
 * @param message [Throwable.message]
 * @param e [Throwable]
 */
class `996Exception` (
    message:String?=null,
    e:Throwable?=null,
) :Exception(message,e),`996Errors` {
    init {
        Config996Errors.whenLogOverrode()
    }
}