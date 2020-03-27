package org.academiadecodigo.ramsters.scumLambda;

public class Machine<T> {

    public T singleOperand(T object, MonoOperation<T> monoOperation) {

        return monoOperation.singleOperand(object);

    }

    public T dualOperand(T object1, T object2, BiOperation<T> biOperation) {

        return biOperation.dualOperand(object1, object2);

    }

    public T multiOperands(ParameterHandler<T> parameterHandler, MultiOperation<T> multiOperation) {



    }

}
