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
import org.clang.basic.*;
import org.clang.parse.*;

//<editor-fold defaultstate="collapsed" desc="clang::PoisonSEHIdentifiersRAIIObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 339,
 FQN="clang::PoisonSEHIdentifiersRAIIObject", NM="_ZN5clang30PoisonSEHIdentifiersRAIIObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang30PoisonSEHIdentifiersRAIIObjectE")
//</editor-fold>
public class PoisonSEHIdentifiersRAIIObject implements Destructors.ClassWithDestructor {
  private PoisonIdentifierRAIIObject Ident_AbnormalTermination;
  private PoisonIdentifierRAIIObject Ident_GetExceptionCode;
  private PoisonIdentifierRAIIObject Ident_GetExceptionInfo;
  private PoisonIdentifierRAIIObject Ident__abnormal_termination;
  private PoisonIdentifierRAIIObject Ident__exception_code;
  private PoisonIdentifierRAIIObject Ident__exception_info;
  private PoisonIdentifierRAIIObject Ident___abnormal_termination;
  private PoisonIdentifierRAIIObject Ident___exception_code;
  private PoisonIdentifierRAIIObject Ident___exception_info;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PoisonSEHIdentifiersRAIIObject::PoisonSEHIdentifiersRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 350,
   FQN="clang::PoisonSEHIdentifiersRAIIObject::PoisonSEHIdentifiersRAIIObject", NM="_ZN5clang30PoisonSEHIdentifiersRAIIObjectC1ERNS_6ParserEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang30PoisonSEHIdentifiersRAIIObjectC1ERNS_6ParserEb")
  //</editor-fold>
  public PoisonSEHIdentifiersRAIIObject(Parser /*&*/ Self, boolean NewValue) {
    // : Ident_AbnormalTermination(Self.Ident_AbnormalTermination, NewValue), Ident_GetExceptionCode(Self.Ident_GetExceptionCode, NewValue), Ident_GetExceptionInfo(Self.Ident_GetExceptionInfo, NewValue), Ident__abnormal_termination(Self.Ident__abnormal_termination, NewValue), Ident__exception_code(Self.Ident__exception_code, NewValue), Ident__exception_info(Self.Ident__exception_info, NewValue), Ident___abnormal_termination(Self.Ident___abnormal_termination, NewValue), Ident___exception_code(Self.Ident___exception_code, NewValue), Ident___exception_info(Self.Ident___exception_info, NewValue) 
    //START JInit
    this.Ident_AbnormalTermination = new PoisonIdentifierRAIIObject(Self.Ident_AbnormalTermination, NewValue);
    this.Ident_GetExceptionCode = new PoisonIdentifierRAIIObject(Self.Ident_GetExceptionCode, NewValue);
    this.Ident_GetExceptionInfo = new PoisonIdentifierRAIIObject(Self.Ident_GetExceptionInfo, NewValue);
    this.Ident__abnormal_termination = new PoisonIdentifierRAIIObject(Self.Ident__abnormal_termination, NewValue);
    this.Ident__exception_code = new PoisonIdentifierRAIIObject(Self.Ident__exception_code, NewValue);
    this.Ident__exception_info = new PoisonIdentifierRAIIObject(Self.Ident__exception_info, NewValue);
    this.Ident___abnormal_termination = new PoisonIdentifierRAIIObject(Self.Ident___abnormal_termination, NewValue);
    this.Ident___exception_code = new PoisonIdentifierRAIIObject(Self.Ident___exception_code, NewValue);
    this.Ident___exception_info = new PoisonIdentifierRAIIObject(Self.Ident___exception_info, NewValue);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PoisonSEHIdentifiersRAIIObject::~PoisonSEHIdentifiersRAIIObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 339,
   FQN="clang::PoisonSEHIdentifiersRAIIObject::~PoisonSEHIdentifiersRAIIObject", NM="_ZN5clang30PoisonSEHIdentifiersRAIIObjectD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang30PoisonSEHIdentifiersRAIIObjectD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Ident___exception_info.$destroy();
    Ident___exception_code.$destroy();
    Ident___abnormal_termination.$destroy();
    Ident__exception_info.$destroy();
    Ident__exception_code.$destroy();
    Ident__abnormal_termination.$destroy();
    Ident_GetExceptionInfo.$destroy();
    Ident_GetExceptionCode.$destroy();
    Ident_AbnormalTermination.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Ident_AbnormalTermination=" + Ident_AbnormalTermination // NOI18N
              + ", Ident_GetExceptionCode=" + Ident_GetExceptionCode // NOI18N
              + ", Ident_GetExceptionInfo=" + Ident_GetExceptionInfo // NOI18N
              + ", Ident__abnormal_termination=" + Ident__abnormal_termination // NOI18N
              + ", Ident__exception_code=" + Ident__exception_code // NOI18N
              + ", Ident__exception_info=" + Ident__exception_info // NOI18N
              + ", Ident___abnormal_termination=" + Ident___abnormal_termination // NOI18N
              + ", Ident___exception_code=" + Ident___exception_code // NOI18N
              + ", Ident___exception_info=" + Ident___exception_info; // NOI18N
  }
}
