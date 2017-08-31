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
package org.clang.lex.java.impl;

import org.clang.lex.llvm.SmallVectorToken;
import org.clang.lex.TokenLexer;
import org.clank.support.Converted;
import static org.clank.support.NativePointer.*;

/**
 * SmallVectorImpl for TokenLexer
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
public final class SmallVectorMacroExpandingLexersStack {
  // constant to be used as defaultValue in other collections.
  // tihs instance is cloned, but have not be modified
  private static final TokenLexer[] EMPTY_LEXERS = new TokenLexer[0];
  private static final int[] EMPTY_INDICES = new$int(0);
  private static final SmallVectorToken[] EMPTY_TOKENS = new SmallVectorToken[0];
  private TokenLexer[] array;
  private int[] indices;
  private SmallVectorToken[] tokens;
  
  private int end;

  public SmallVectorMacroExpandingLexersStack(int capacity) {
    this.array = (TokenLexer[]) (capacity == 0 ? EMPTY_LEXERS : new TokenLexer[capacity]);
    this.indices = (int[]) (capacity == 0 ? EMPTY_INDICES : new$int(capacity));
    this.tokens = (SmallVectorToken[]) (capacity == 0 ? EMPTY_TOKENS : new SmallVectorToken[capacity]);
    this.end = 0;
  }
  
  public final TokenLexer first$at(int idx) {
    assert array[idx] != null;
    return array[idx];
  }

  public final int second$at(int idx) {
    return indices[idx];
  }

  public final SmallVectorToken tokens$at(int idx) {
    return tokens[idx];
  }

  public final boolean empty() {
    return this.size() == 0;
  }
  
  public final void $destroy() {
    destroy_range(0, this.size());
    end = 0;
  }
  
  public final void push_back(TokenLexer val, SmallVectorToken tokens, int index) {
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    this.array[end] = val;
    this.tokens[end] = tokens;
    indices[end] = index;
    end++;
  }    

  public final TokenLexer back$first() {
    return array[end - 1];
  }  
  
  public final int back$second() {
    return indices[end - 1];
  }  
  
  public final SmallVectorToken back$tokens() {
    return tokens[end - 1];
  }  
  
  public final void pop_back() {
    this.array[--end] = null;
    this.tokens[end] = null;
  } 

  public final /*size_t*/int size() /*const*/ {
    return end;
  }
  
  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public final /*size_t*/int capacity() /*const*/ {
    assert array.length == indices.length;
    assert array.length == tokens.length;
    return array.length;
  }

  private void destroy_range(int from, int to) {
     for (int i = from; i < to; i++) { 
       array[i] = null;
       tokens[i] = null;
     }
  }

  private void grow(int newSize) {
    TokenLexer[] oldArray = array;
    array = new TokenLexer[newSize];
    copy$Object(oldArray, 0, array, 0, oldArray.length);
    SmallVectorToken[] oldTokens = tokens;
    tokens = new SmallVectorToken[newSize];
    copy$Object(oldTokens, 0, tokens, 0, oldTokens.length);
    indices = copyOf$int(indices, newSize);
  }

  private void grow() {
    int capacity = capacity();
    this.grow(capacity == 0 ? 1 : ((capacity < 1024) ? capacity * 2 : (capacity + 1024)));
  }  
  
  private void setEnd(int to) {
    end = to;
  }  

  @Override
  public String toString() {
    if (this.end == 0) {
      return "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\nSmallVectorTokenLexer{\nend = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      TokenLexer element = array[i];
      int idx = indices[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(idx).append("=").append(element).append('\n');
    }
    out.append("}SmallVectorTokenLexer}\n");
    return out.toString();
  }
}
