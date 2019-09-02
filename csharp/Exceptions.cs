using System;
using System.Runtime.Serialization;

namespace jsmod2.command
{
    public class _996Exception : Exception
    {
        public _996Exception()
        {
        }

        protected _996Exception(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }

        public _996Exception(string message) : base(message)
        {
        }

        public _996Exception(string message, Exception innerException) : base(message, innerException)
        {
        }
    }

    public class _996RuntimeException : SystemException
    {
        public _996RuntimeException()
        {
        }

        protected _996RuntimeException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }

        public _996RuntimeException(string message) : base(message)
        {
        }

        public _996RuntimeException(string message, Exception innerException) : base(message, innerException)
        {
        }
    }
}