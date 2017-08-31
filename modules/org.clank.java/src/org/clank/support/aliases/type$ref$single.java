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

import org.clank.support.AbstractSinglePointerType;
import org.clank.support.Converted;
import org.clank.support.NativeTrace;

/**
 * Lightest implementation of pointer to T
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/pointersingleimpl.tpl")
//</editor-fold>
public final class type$ref$single<T> extends AbstractSinglePointerType<type$ptr<T>> implements type$ptr<T>, type$ref<T> {
    
    private T val;

    public type$ref$single() {
        this((T)null);
    }
    
    public type$ref$single(T val) {
        this.val = val;
        trackInstance();
    }

    ////////////////////////////////////////////////////////////////////////////
    // common operations
    @Override
    public boolean $isNull() {
      return val == null;
    }
  
    @Override
    public T $deref() {
      return $star();
    }

    @Override
    public T $star() {
      return val;
    }

    @Override
    public T $set(T value) {
        val = value;
        return val;
    }

    @Override
    public T $at(int index) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return val;
    }

    @Override
    public T $set(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val = value;
    }       
    /*
    @Override
    public T $set$andassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val &= value;
    }

    @Override
    public T $set$andassign(T value) {
        return this.val &= value;
    }

    @Override
    public T $set$xorassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val ^= value;
    }

    @Override
    public T $set$xorassign(T value) {
        return this.val ^= value;
    }

    @Override
    public T $set$orassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val |= value;
    }
    
    @Override
    public T $set$orassign(T value) {
        return this.val |= value;
    }
    
    *//*

    @Override
    public T $set$addassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val += value;
    }

    @Override
    public T $set$addassign(T value) {
        return this.val += value;
    }

    @Override
    public T $set$minusassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val -= value;
    }

    @Override
    public T $set$minusassign(T value) {
        return this.val -= value;
    }

    @Override
    public T $set$starassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val *= value;
    }

    @Override
    public T $set$starassign(T value) {
        return this.val *= value;
    }

    @Override
    public T $set$slashassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val /= value;
    }

    @Override
    public T $set$slashassign(T value) {
        return this.val /= value;
    }

    @Override
    public T $set$modassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val %= value;
    }

    @Override
    public T $set$modassign(T value) {
        return this.val %= value;
    }

    @Override
    public T $set$lshiftassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val <<= value;
    }

    @Override
    public T $set$rshiftassign(int index, T value) {
        if (index != 0) {
            throw new IllegalArgumentException("Index must be zero to access to the single variable!");
        }
        return this.val >>= value;
    }

    @Override
    public T $set$rshiftassign(T value) {
        return this.val >>= value;
    }

    @Override
    public T $set$postInc(int index) {
        return this.val++;
    }

    @Override
    public T $set$postInc() {
        return this.val++;
    }

    @Override
    public T $set$postDec(int index) {
        return this.val--;
    }

    @Override
    public T $set$postDec() {
        return this.val--;
    }

    @Override
    public T $set$preInc(int index) {
        return ++this.val;
    }

    @Override
    public T $set$preInc() {
        return ++this.val;
    }

    @Override
    public T $set$preDec(int index) {
        return --this.val;
    }

    @Override
    public T $set$preDec() {
        return --this.val;
    }

    */

    @Override
    public type$ptr<T> $assign(type$ptr<T> value) {
        throw new UnsupportedOperationException("Use $set(value.$star()) instead!");
    }

    @Override
    public type$ref<T> star$ref() {
      return this;
    }

    @Override
    public type$ptr<T> deref$ptr() {
      return this;
    }

    @Override
    public String toString() {
      return "type$ref$single{" + val + "}";
    }    

    ////////////////////////////////////////////////////////////////////////////
    // statistics
    private static long instances = 0;
    
    public static void trackInstance() {        
        if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {        
        instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
        out.printf("%22s created:\t%s%n", type$ref$single.class.getSimpleName(), NativeTrace.formatNumber(instances));
        return instances;
    }

    ///////////////////////////////////////////////////////////////////////////
    // performance access operations

    @Override
    public int $index() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

    @Override
    public T[] $array() {
      throw new UnsupportedOperationException("Not supported; create array based instance instead");
    }

}