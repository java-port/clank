/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clank.support.aliases;

import org.clank.support.AbstractArrayPointerType;
import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import org.clank.support.void$ptr;

/**
 * Array based implementation of pointer to long
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointerarrayimpl.tpl")
//</editor-fold>
public final class long$ptr$array extends AbstractArrayPointerType<long$ptr> implements long$ptr {
    
    /*package*//*friend AliasesAccessor*/ long[] array;

    protected long$ptr$array(long$ptr$array other, boolean makeConstPtr, boolean makeConstContent) {
      super(other, makeConstPtr, adjustImmutableContent(makeConstContent, other.array));
      this.array = other.array;
      trackInstance(makeConstPtr, makeConstContent);
    }
  
    public long$ptr$array() {
        this(null, 0, false, false);
    }

    public long$ptr$array(long[] arr) {
        this(arr, 0, false, false);
    }

    public long$ptr$array(long[] arr, int idx) {
        this(arr, idx, false, false);
    }

    public long$ptr$array(long[] arr, boolean makeConstPtr) {
        this(arr, 0, makeConstPtr, false);
    }

    public long$ptr$array(long[] arr, int idx, boolean makeConstPtr) {
        this(arr, idx, makeConstPtr, false);
    }

    public long$ptr$array(long[] arr, int idx, boolean makeConstPtr, boolean makeConstContent) {
        super(makeConstPtr, adjustImmutableContent(makeConstContent, arr));
        this.array = arr;
        assert idx >= 0 : "can not be negative " + idx;
        this.index = idx;
        trackInstance(makeConstPtr, makeConstContent);
    }

    private static boolean adjustImmutableContent(boolean curConstValue, Object/*long[]*/ arrayToCheck) {
      // PERF: in debug for registered immutable arrays force const-content mode as well
      assert (curConstValue |= !NativeTrace.getArrayName(arrayToCheck).isEmpty()) || true;
      return curConstValue;
    }

    ///////////////////////////////////////////////////////////////////////////
    // common operations

    @Override
    public boolean $isNull() {
        return array == null;
    }

    @Override
    public long $star() {
        return array[index];
    }

    @Override
    public long $set(long value) {
        return $set(0, value);
    }

    @Override
    public long $at(int index) {
        return array[(this.index + index)];
    }

    @Override
    public int $sub(long$ptr other) {
      assert other instanceof long$ptr$array : "unexpected object " + other;
      return (index - ((long$ptr$array)other).index);
    }
    
    @Override
    public long$ptr$array $add(int amount) {
      long$ptr$array cloned = new long$ptr$array(this, false, _isConstContent());
      cloned.index += amount;
      return cloned;
    }

    @Override
    public long$ptr$array $sub(int amount) {
      long$ptr$array cloned = new long$ptr$array(this, false, _isConstContent());
      cloned.index -= amount;
      return cloned;
    }
  
    @Override
    public long $set(int index, long value) {
      assert !_isConstContent() : "Cannot modify content because it is constant!";
      return array[(int)(this.index + index)] = value;
    }   
    
    @Override
    public long $set$andassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] &= value;
    }

    @Override
    public long $set$xorassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] ^= value;
    }

    @Override
    public long $set$orassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] |= value;
    }

    

    @Override
    public long $set$addassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] += value;
    }

    @Override
    public long $set$minusassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] -= value;
    }

    @Override
    public long $set$starassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] *= value;
    }

    @Override
    public long $set$slashassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] /= value;
    }

    @Override
    public long $set$modassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] %= value;
    }

    @Override
    public long $set$lshiftassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] <<= value;
    }

    @Override
    public long $set$rshiftassign(int index, long value) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)] >>= value;
    }

    @Override
    public long $set$postInc(int index) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)]++;
    }
    
    @Override
    public long $set$postDec(int index) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return array[(this.index + index)]--;
    }

    @Override
    public long $set$preInc(int index) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return ++array[(this.index + index)];
    }

    @Override
    public long $set$preDec(int index) {
        assert !_isConstContent() : "Cannot modify content because it is constant!";
        return --array[(this.index + index)];
    }

    

    @Override
    public long$ptr $assign(long$ptr value) {
        assert !_isConstPtr() : "Cannot modify const object!";
        if (value == null) {
            array = null;
            index = 0;
            return this;
        } else if (value instanceof long$ptr$array) {
            long$ptr$array val = (long$ptr$array)value;
            array = val.array;
            index = val.index;
            // keep constness of copied value
            if (val._isConstContent()) {
              super.$toConstContent();
            }
            return this;
        } 
        throw new IllegalArgumentException(
                "Different pointer types: expected '" + getClass().getName() + "'" 
                + ", but found '" + (value != null ? value.getClass() : "null") + "'"
        );            
    }

    @Override
    public boolean isComparableTo(void$ptr other) {
      return other instanceof long$ptr$array && ((long$ptr$array) other).array == this.array;
    }
    
    @Override
    public boolean $less(Object obj) {
        if (obj instanceof long$ptr$array) {
            long$ptr$array other = (long$ptr$array) obj;
            return other.array == this.array && ((index - other.index) < 0);
        }
        throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
    }

    @Override
    public boolean $lesseq(Object obj) {
        if (obj instanceof long$ptr$array) {
            long$ptr$array other = (long$ptr$array) obj;
            return other.array == this.array && ((index - other.index) <= 0);
        }
        throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());
    }

    @Override
    public boolean $greater(Object obj) {
        if (obj instanceof long$ptr$array) {
            long$ptr$array other = (long$ptr$array) obj;
            return other.array == this.array && ((index - other.index) > 0);
        }
        throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());          
    }

    @Override
    public boolean $greatereq(Object obj) {
        if (obj instanceof long$ptr$array) {
            long$ptr$array other = (long$ptr$array) obj;
            return other.array == this.array && ((index - other.index) >= 0);
        }
        throw new IllegalArgumentException("Not comparable pointer types: " + getClass() + " and " + obj.getClass());          
    }
    
    @Override
    public boolean $eq(Object p) {
        if (p instanceof long$ptr$array) {
            long$ptr$array other = (long$ptr$array) p;
            return other.array == this.array && index == other.index;
        }
        return false;
    }

    @Override
    public boolean $noteq(Object p) {
        return !$eq(p);
    }        

    @Override
    public long$ref star$ref() {
      return new long$ref() {

            // use outer instance if only $set/$deref is needed
            long$ptr$array localPtr = long$ptr$array.this;

            @Override
            public long $deref() {
                return localPtr.$star();
            }

            @Override
            public long $set(long value) {
                return localPtr.$set(value);
            }

            @Override
            public long$ptr deref$ptr() {
                // we have to make a copy,
                // otherwise ++/-- will change outer instance
                if (localPtr == long$ptr$array.this) {
                  localPtr = localPtr.clone();
                }
                return localPtr;
            }
        };
    }

    @Override
    public int $hashcode() {
        return (System.identityHashCode(this.array)) ^ index;
    }

    @Override
    public long$ptr$array clone() {
      return new long$ptr$array(this, false, _isConstContent());
    }

    @Override
    public long$ptr$array const_clone() {
      return super._isConstPtr() ? this : new long$ptr$array(this, true, _isConstContent());
    }

    @Override
    public String toString() {
      String arrName = NativeTrace.getArrayName(array);
      if (array == null || array.length == 0) {
        return arrName + "<EMPTY>";
      }
      StringBuilder sb = new StringBuilder(arrName + "\n" + char$ptr$array.class.getSimpleName() + "{range=[" + this.index + "-" + array.length + "]\n");
      String fmt = "%" + (int) Math.ceil(Math.log10(array.length + 1)) + "d";
      for (int i = (int) this.index; i < array.length; i++) {
        long b = array[i];
        sb.append((i == this.index) ? "*[" : " [").append(String.format(fmt, i)).append("]");
				sb.append(b).append(NEW_LINE);
        if ((i - this.index) > NativeTrace.TO_STRING_LIMIT) {
          sb.append("...."); break;
        }
      }
      sb.append("}").append(long$ptr$array.class.getSimpleName()).append("\n");
      return sb.toString();
    }  

    ////////////////////////////////////////////////////////////////////////////
    // statistics
    private static long nonConstInstances = 0;
    private static long constPtrInstances = 0;
    private static long constContentInstances = 0;
    private static long fullyConstInstances = 0;

    public static void trackInstance(boolean constPtr, boolean constContent) {
        if (NativeTrace.STATISTICS) {
            if (constPtr && constContent) {
                fullyConstInstances++;
            } else if (constPtr) {
                constPtrInstances++;
            } else if (constContent) {
                constContentInstances++;
            } else {
                nonConstInstances++;
            }
        }
    }

    public static void clearStatistics() {
        fullyConstInstances = 0;
        constPtrInstances = 0;
        constContentInstances = 0;
        nonConstInstances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
        final long totalInstances = nonConstInstances + fullyConstInstances + constPtrInstances + constContentInstances;
        out.printf("%30s created all:\t%s%n", long$ptr$array.class.getSimpleName(), NativeTrace.formatNumber(totalInstances));
        out.printf("%32s non const:\t%s%n", long$ptr$array.class.getSimpleName(), NativeTrace.formatNumber(nonConstInstances));
        out.printf("%32s const ptr:\t%s%n", long$ptr$array.class.getSimpleName(), NativeTrace.formatNumber(constPtrInstances));
        out.printf("%28s const content:\t%s%n", long$ptr$array.class.getSimpleName(), NativeTrace.formatNumber(constContentInstances));
        out.printf("%20s const ptr and content:\t%s%n", long$ptr$array.class.getSimpleName(), NativeTrace.formatNumber(fullyConstInstances));
        return totalInstances;
    }
    ///////////////////////////////////////////////////////////////////////////
    // performance access operations
    public final long[] $array() {
      return this.array;
    }
}