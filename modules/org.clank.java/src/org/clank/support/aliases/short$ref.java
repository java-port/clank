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
 * Reference to short
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/support/aliases/templates/reference.tpl")
//</editor-fold>
public interface short$ref extends Native.Native$Bool {

  short $deref();
  
  short $set(short value);
  
  default short $setMove(short value) { return $set(value); }
  
  default short $assign(short value) { return $set(value); }
  
  default short$ptr deref$ptr() { throw new UnsupportedOperationException(); }

  
  default short $set$andassign(short value) { // "&="
    short newVal = (short)($deref() & value);
    return $set(newVal);
  }
  default short $set$xorassign(short value) { // "^="
    short newVal = (short)($deref() ^ value);
    return $set(newVal);
  }
  default short $set$orassign(short value) { // "|=" 
    short newVal = (short)($deref() | value);
    return $set(newVal);
  }
  
  default short $set$addassign(short value) {// "+=" 
    short newVal = (short)($deref() + value);
    return $set(newVal);
  }
  default short $set$minusassign(short value) {// "-="
    short newVal = (short)($deref() - value);
    return $set(newVal);
  }
  default short $set$starassign(short value) {// "*="    
    short newVal = (short)($deref() * value);
    return $set(newVal);
  }
  default short $set$slashassign(short value) {// "/="
    short newVal = (short)($deref() / value);
    return $set(newVal);
  }
  default short $set$modassign(short value) {// "%=" 
    short newVal = (short)($deref() % value);
    return $set(newVal);
  }
  default short $set$lshiftassign(short value) {// "<<="
    short newVal = (short)($deref() << value);
    return $set(newVal);
  }
  default short $set$rshiftassign(short value) {// ">>="
    short newVal = (short)($deref() >> value);
    return $set(newVal);
  }
  default short $set$postInc() {// "x++"
    short oldVal = $deref();
    $set((short)(oldVal+1));
    return oldVal;
  }    
  default short $set$postDec() {// "x--"    
    short oldVal = $deref();
    $set((short)(oldVal-1));
    return oldVal;
  }    
  default short $set$preInc() {// "++x"    
    short newVal = (short)($deref() + 1);
    return $set(newVal);
  }
  default short $set$preDec() {// "--x"  
    short newVal = (short)($deref() - 1);
    return $set(newVal);
  }
  
}