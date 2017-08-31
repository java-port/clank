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
package org.clank.java.stdimpl.aliases;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;

//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdReverseIterator.tpl")
//</editor-fold>
public abstract class StdReverseIteratorULong implements ulong$iterator<std.reverse_iteratorULong> {
    
    private ulong$iterator<?> delegate;

    public StdReverseIteratorULong(ulong$iterator<?> delegate) {
      this.delegate = Native.$tryClone(delegate);
    }

    public StdReverseIteratorULong(JavaDifferentiators.JD$NoCloneInput _dparm, ulong$iterator<?> delegate) {
      this.delegate = delegate;
    }

    public StdReverseIteratorULong(StdReverseIteratorULong other) {
      this.delegate = Native.$tryClone(other.delegate);
    }
    
    @Override
    public long $star() {
      ulong$iterator<?> tmp = delegate.clone();
      tmp.$preDec();
      return tmp.$star();
    }

    public std.reverse_iteratorULong $assign(std.reverse_iteratorULong other) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public int $sub(std.reverse_iteratorULong iter) {
      // Subtract in reverse order: iter - this
      ulong$iterator first = (ulong$iterator) this.delegate;
      ulong$iterator last = (ulong$iterator) ((StdReverseIteratorULong) iter).delegate;
      return last.$sub(first);
    }

    @Override
    public std.reverse_iteratorULong $preInc() {
      delegate.$preDec();
      return (std.reverse_iteratorULong) this;
    }

    @Override
    public std.reverse_iteratorULong $preDec() {
      delegate.$preInc();
      return (std.reverse_iteratorULong) this;
    }

    @Override
    public std.reverse_iteratorULong $postInc() {
      std.reverse_iteratorULong cloned = clone();
      delegate.$preDec();
      return cloned;
    }

    @Override
    public std.reverse_iteratorULong $postDec() {
      std.reverse_iteratorULong cloned = clone();
      delegate.$preInc();
      return cloned;
    }

    @Override
    public std.reverse_iteratorULong $inc(int amount) {
      delegate.$dec(amount);
      return (std.reverse_iteratorULong) this;
    }

    @Override
    public std.reverse_iteratorULong $dec(int amount) {
      delegate.$inc(amount);
      return (std.reverse_iteratorULong) this;
    }

    @Override
    public std.reverse_iteratorULong $add(int amount) {
      return new std.reverse_iteratorULong(delegate.$sub(amount));
    }

    @Override
    public std.reverse_iteratorULong $sub(int amount) {
      return new std.reverse_iteratorULong(delegate.$add(amount));
    }

    @Override
    public boolean $noteq(Object other) {
      return Native.$noteq_iter(delegate, (((StdReverseIteratorULong) other).delegate));
    }

    @Override
    public boolean $eq(Object other) {
      return Native.$eq_iter(delegate, (((StdReverseIteratorULong) other).delegate));
    }

    @Override
    public std.reverse_iteratorULong clone() {
      return new std.reverse_iteratorULong(delegate.clone());
    }

    @Override
    public std.reverse_iteratorULong const_clone() {
      return new std.reverse_iteratorULong(delegate.const_clone());
    }

    @Override
    public ulong$ref star$ref() {
      return new ulong$ref() {

        ulong$iterator<?> localIter = delegate.clone();

        @Override
        public long $deref() {
          return localIter.$star();
        }

        @Override
        public long $set(long value) {
          return localIter.star$ref().$set(value);
        }

        @Override
        public ulong$ptr deref$ptr() {
          return localIter.star$ref().deref$ptr();
        }
      };
    }    

    public ulong$iterator<?> base() {
      return delegate.clone();
    }
    
    @Override public String toString() {
      return "Reverse[" + this.delegate + "]";
    }
}
