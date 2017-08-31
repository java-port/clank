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

package org.clang.parse.impl;

import org.clank.support.*;
import org.clang.parse.*;


/// ColonProtectionRAIIObject - This sets the Parser::ColonIsSacred bool and
/// restores it when destroyed.  This says that "foo:" should not be
/// considered a possible typo for "foo::" for error recovery purposes.
//<editor-fold defaultstate="collapsed" desc="clang::ColonProtectionRAIIObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 270,
 FQN="clang::ColonProtectionRAIIObject", NM="_ZN5clang25ColonProtectionRAIIObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang25ColonProtectionRAIIObjectE")
//</editor-fold>
public class ColonProtectionRAIIObject implements Destructors.ClassWithDestructor {
  private Parser /*&*/ P;
  private boolean OldVal;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ColonProtectionRAIIObject::ColonProtectionRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 274,
   FQN="clang::ColonProtectionRAIIObject::ColonProtectionRAIIObject", NM="_ZN5clang25ColonProtectionRAIIObjectC1ERNS_6ParserEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang25ColonProtectionRAIIObjectC1ERNS_6ParserEb")
  //</editor-fold>
  public ColonProtectionRAIIObject(Parser /*&*/ p) {
    this(p, true);
  }
  public ColonProtectionRAIIObject(Parser /*&*/ p, boolean Value/*= true*/) {
    // : P(p), OldVal(P.ColonIsSacred) 
    //START JInit
    this./*&*/P=/*&*/p;
    this.OldVal = P.ColonIsSacred;
    //END JInit
    P.ColonIsSacred = Value;
  }

  
  /// restore - This can be used to restore the state early, before the dtor
  /// is run.
  //<editor-fold defaultstate="collapsed" desc="clang::ColonProtectionRAIIObject::restore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 281,
   FQN="clang::ColonProtectionRAIIObject::restore", NM="_ZN5clang25ColonProtectionRAIIObject7restoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang25ColonProtectionRAIIObject7restoreEv")
  //</editor-fold>
  public void restore() {
    P.ColonIsSacred = OldVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ColonProtectionRAIIObject::~ColonProtectionRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 285,
   FQN="clang::ColonProtectionRAIIObject::~ColonProtectionRAIIObject", NM="_ZN5clang25ColonProtectionRAIIObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang25ColonProtectionRAIIObjectD0Ev")
  //</editor-fold>
  public void $destroy() {
    restore();
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT PARSER "P=" + P */// NOI18N
              + ", OldVal=" + OldVal; // NOI18N
  }
}
