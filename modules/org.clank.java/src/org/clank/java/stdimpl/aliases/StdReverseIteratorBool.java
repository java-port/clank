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
public abstract class StdReverseIteratorBool implements bool$iterator<std.reverse_iteratorBool> {
    
    private bool$iterator<?> delegate;

    public StdReverseIteratorBool(bool$iterator<?> delegate) {
      this.delegate = Native.$tryClone(delegate);
    }

    public StdReverseIteratorBool(JavaDifferentiators.JD$NoCloneInput _dparm, bool$iterator<?> delegate) {
      this.delegate = delegate;
    }

    public StdReverseIteratorBool(StdReverseIteratorBool other) {
      this.delegate = Native.$tryClone(other.delegate);
    }
    
    @Override
    public boolean $star() {
      bool$iterator<?> tmp = delegate.clone();
      tmp.$preDec();
      return tmp.$star();
    }

    public std.reverse_iteratorBool $assign(std.reverse_iteratorBool other) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public int $sub(std.reverse_iteratorBool iter) {
      // Subtract in reverse order: iter - this
      bool$iterator first = (bool$iterator) this.delegate;
      bool$iterator last = (bool$iterator) ((StdReverseIteratorBool) iter).delegate;
      return last.$sub(first);
    }

    @Override
    public std.reverse_iteratorBool $preInc() {
      delegate.$preDec();
      return (std.reverse_iteratorBool) this;
    }

    @Override
    public std.reverse_iteratorBool $preDec() {
      delegate.$preInc();
      return (std.reverse_iteratorBool) this;
    }

    @Override
    public std.reverse_iteratorBool $postInc() {
      std.reverse_iteratorBool cloned = clone();
      delegate.$preDec();
      return cloned;
    }

    @Override
    public std.reverse_iteratorBool $postDec() {
      std.reverse_iteratorBool cloned = clone();
      delegate.$preInc();
      return cloned;
    }

    @Override
    public std.reverse_iteratorBool $inc(int amount) {
      delegate.$dec(amount);
      return (std.reverse_iteratorBool) this;
    }

    @Override
    public std.reverse_iteratorBool $dec(int amount) {
      delegate.$inc(amount);
      return (std.reverse_iteratorBool) this;
    }

    @Override
    public std.reverse_iteratorBool $add(int amount) {
      return new std.reverse_iteratorBool(delegate.$sub(amount));
    }

    @Override
    public std.reverse_iteratorBool $sub(int amount) {
      return new std.reverse_iteratorBool(delegate.$add(amount));
    }

    @Override
    public boolean $noteq(Object other) {
      return Native.$noteq_iter(delegate, (((StdReverseIteratorBool) other).delegate));
    }

    @Override
    public boolean $eq(Object other) {
      return Native.$eq_iter(delegate, (((StdReverseIteratorBool) other).delegate));
    }

    @Override
    public std.reverse_iteratorBool clone() {
      return new std.reverse_iteratorBool(delegate.clone());
    }

    @Override
    public std.reverse_iteratorBool const_clone() {
      return new std.reverse_iteratorBool(delegate.const_clone());
    }

    @Override
    public bool$ref star$ref() {
      return new bool$ref() {

        bool$iterator<?> localIter = delegate.clone();

        @Override
        public boolean $deref() {
          return localIter.$star();
        }

        @Override
        public boolean $set(boolean value) {
          return localIter.star$ref().$set(value);
        }

        @Override
        public bool$ptr deref$ptr() {
          return localIter.star$ref().deref$ptr();
        }
      };
    }    

    public bool$iterator<?> base() {
      return delegate.clone();
    }
    
    @Override public String toString() {
      return "Reverse[" + this.delegate + "]";
    }
}
