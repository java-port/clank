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
public abstract class StdReverseIteratorDouble implements double$iterator<std.reverse_iteratorDouble> {
    
    private double$iterator<?> delegate;

    public StdReverseIteratorDouble(double$iterator<?> delegate) {
      this.delegate = Native.$tryClone(delegate);
    }

    public StdReverseIteratorDouble(JavaDifferentiators.JD$NoCloneInput _dparm, double$iterator<?> delegate) {
      this.delegate = delegate;
    }

    public StdReverseIteratorDouble(StdReverseIteratorDouble other) {
      this.delegate = Native.$tryClone(other.delegate);
    }
    
    @Override
    public double $star() {
      double$iterator<?> tmp = delegate.clone();
      tmp.$preDec();
      return tmp.$star();
    }

    public std.reverse_iteratorDouble $assign(std.reverse_iteratorDouble other) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public int $sub(std.reverse_iteratorDouble iter) {
      // Subtract in reverse order: iter - this
      double$iterator first = (double$iterator) this.delegate;
      double$iterator last = (double$iterator) ((StdReverseIteratorDouble) iter).delegate;
      return last.$sub(first);
    }

    @Override
    public std.reverse_iteratorDouble $preInc() {
      delegate.$preDec();
      return (std.reverse_iteratorDouble) this;
    }

    @Override
    public std.reverse_iteratorDouble $preDec() {
      delegate.$preInc();
      return (std.reverse_iteratorDouble) this;
    }

    @Override
    public std.reverse_iteratorDouble $postInc() {
      std.reverse_iteratorDouble cloned = clone();
      delegate.$preDec();
      return cloned;
    }

    @Override
    public std.reverse_iteratorDouble $postDec() {
      std.reverse_iteratorDouble cloned = clone();
      delegate.$preInc();
      return cloned;
    }

    @Override
    public std.reverse_iteratorDouble $inc(int amount) {
      delegate.$dec(amount);
      return (std.reverse_iteratorDouble) this;
    }

    @Override
    public std.reverse_iteratorDouble $dec(int amount) {
      delegate.$inc(amount);
      return (std.reverse_iteratorDouble) this;
    }

    @Override
    public std.reverse_iteratorDouble $add(int amount) {
      return new std.reverse_iteratorDouble(delegate.$sub(amount));
    }

    @Override
    public std.reverse_iteratorDouble $sub(int amount) {
      return new std.reverse_iteratorDouble(delegate.$add(amount));
    }

    @Override
    public boolean $noteq(Object other) {
      return Native.$noteq_iter(delegate, (((StdReverseIteratorDouble) other).delegate));
    }

    @Override
    public boolean $eq(Object other) {
      return Native.$eq_iter(delegate, (((StdReverseIteratorDouble) other).delegate));
    }

    @Override
    public std.reverse_iteratorDouble clone() {
      return new std.reverse_iteratorDouble(delegate.clone());
    }

    @Override
    public std.reverse_iteratorDouble const_clone() {
      return new std.reverse_iteratorDouble(delegate.const_clone());
    }

    @Override
    public double$ref star$ref() {
      return new double$ref() {

        double$iterator<?> localIter = delegate.clone();

        @Override
        public double $deref() {
          return localIter.$star();
        }

        @Override
        public double $set(double value) {
          return localIter.star$ref().$set(value);
        }

        @Override
        public double$ptr deref$ptr() {
          return localIter.star$ref().deref$ptr();
        }
      };
    }    

    public double$iterator<?> base() {
      return delegate.clone();
    }
    
    @Override public String toString() {
      return "Reverse[" + this.delegate + "]";
    }
}
