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

import org.clank.support.Converted;
import org.clank.support.Native;

/**
 * Reference to boolean
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/reference.tpl")
//</editor-fold>
public interface bool$ref extends Native.Native$Bool {

  boolean $deref();
  
  boolean $set(boolean value);
  
  default boolean $setMove(boolean value) { return $set(value); }
  
  default boolean $assign(boolean value) { return $set(value); }
  
  default bool$ptr deref$ptr() { throw new UnsupportedOperationException(); }

  
  default boolean $set$andassign(boolean value) { // "&="
    boolean newVal = (boolean)($deref() & value);
    return $set(newVal);
  }
  default boolean $set$xorassign(boolean value) { // "^="
    boolean newVal = (boolean)($deref() ^ value);
    return $set(newVal);
  }
  default boolean $set$orassign(boolean value) { // "|=" 
    boolean newVal = (boolean)($deref() | value);
    return $set(newVal);
  }
  /*
  default boolean $set$addassign(boolean value) {// "+=" 
    boolean newVal = (boolean)($deref() + value);
    return $set(newVal);
  }
  default boolean $set$minusassign(boolean value) {// "-="
    boolean newVal = (boolean)($deref() - value);
    return $set(newVal);
  }
  default boolean $set$starassign(boolean value) {// "*="    
    boolean newVal = (boolean)($deref() * value);
    return $set(newVal);
  }
  default boolean $set$slashassign(boolean value) {// "/="
    boolean newVal = (boolean)($deref() / value);
    return $set(newVal);
  }
  default boolean $set$modassign(boolean value) {// "%=" 
    boolean newVal = (boolean)($deref() % value);
    return $set(newVal);
  }
  default boolean $set$lshiftassign(boolean value) {// "<<="
    boolean newVal = (boolean)($deref() << value);
    return $set(newVal);
  }
  default boolean $set$rshiftassign(boolean value) {// ">>="
    boolean newVal = (boolean)($deref() ${RSHIFT_OP} value);
    return $set(newVal);
  }
  default boolean $set$postInc() {// "x++"
    boolean oldVal = $deref();
    $set((boolean)(oldVal+1));
    return oldVal;
  }    
  default boolean $set$postDec() {// "x--"    
    boolean oldVal = $deref();
    $set((boolean)(oldVal-1));
    return oldVal;
  }    
  default boolean $set$preInc() {// "++x"    
    boolean newVal = (boolean)($deref() + 1);
    return $set(newVal);
  }
  default boolean $set$preDec() {// "--x"  
    boolean newVal = (boolean)($deref() - 1);
    return $set(newVal);
  }
  */
}