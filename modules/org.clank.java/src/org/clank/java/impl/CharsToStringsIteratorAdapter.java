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


package org.clank.java.impl;

import org.clank.java.std;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ref;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class CharsToStringsIteratorAdapter implements type$iterator<CharsToStringsIteratorAdapter, std.string> {
    
    private type$iterator<?, char$ptr> charsIterator;

    public CharsToStringsIteratorAdapter(type$iterator<?, char$ptr> charsIterator) {
      this.charsIterator = charsIterator;
    }

    @Override
    public std.string $star() {
      return new std.string(charsIterator.$star());
    }

    @Override
    public type$ref<std.string> star$ref() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public int $sub(CharsToStringsIteratorAdapter iter) {
      return ((type$iterator) charsIterator).$sub(iter.charsIterator);
    }

    @Override
    public CharsToStringsIteratorAdapter $preInc() {
      charsIterator.$preInc();
      return this;
    }

    @Override
    public CharsToStringsIteratorAdapter $preDec() {
      charsIterator.$preDec();
      return this;
    }

    @Override
    public CharsToStringsIteratorAdapter $postInc() {
      return new CharsToStringsIteratorAdapter(charsIterator.$postInc());
    }

    @Override
    public CharsToStringsIteratorAdapter $postDec() {
      return new CharsToStringsIteratorAdapter(charsIterator.$postDec());
    }

    @Override
    public CharsToStringsIteratorAdapter $inc(int amount) {
      charsIterator.$inc(amount);
      return this;
    }

    @Override
    public CharsToStringsIteratorAdapter $dec(int amount) {
      charsIterator.$dec(amount);
      return this;
    }

    @Override
    public CharsToStringsIteratorAdapter $add(int amount) {
      return new CharsToStringsIteratorAdapter(charsIterator.$add(amount));
    }

    @Override
    public CharsToStringsIteratorAdapter $sub(int amount) {
      return new CharsToStringsIteratorAdapter(charsIterator.$sub(amount));
    }

    @Override
    public CharsToStringsIteratorAdapter clone() {
      return new CharsToStringsIteratorAdapter($tryClone(charsIterator));
    }

    @Override
    public CharsToStringsIteratorAdapter const_clone() {
      // TODO: pass constness
      return new CharsToStringsIteratorAdapter($tryClone(charsIterator));
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(Object other) {
      return other instanceof CharsToStringsIteratorAdapter && charsIterator.$eq(((CharsToStringsIteratorAdapter) other).charsIterator);
    }
    
  }
