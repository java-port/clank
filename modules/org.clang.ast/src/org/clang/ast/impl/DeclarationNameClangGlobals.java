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
package org.clang.ast.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclarationNameClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanggeENS_15DeclarationNameES0_;_ZN5clanggtENS_15DeclarationNameES0_;_ZN5clangleENS_15DeclarationNameES0_;_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE;_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE;_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE;_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE;_ZN5clangltENS_15DeclarationNameES0_; -static-type=DeclarationNameClangGlobals -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclarationNameClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 219,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_DeclarationName(final raw_ostream /*&*/ OS, DeclarationName N) {
  LangOptions LO/*J*/= new LangOptions();
  N.print(OS, new PrintingPolicy(LO));
  return OS;
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 316,
 FQN="clang::operator<", NM="_ZN5clangltENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clangltENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $less_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return DeclarationName.compare(/*NO_COPY*/LHS, /*NO_COPY*/RHS) < 0;
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 322,
 FQN="clang::operator>", NM="_ZN5clanggtENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanggtENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $greater_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return DeclarationName.compare(/*NO_COPY*/LHS, /*NO_COPY*/RHS) > 0;
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator<=">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 328,
 FQN="clang::operator<=", NM="_ZN5clangleENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clangleENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $lesseq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return DeclarationName.compare(/*NO_COPY*/LHS, /*NO_COPY*/RHS) <= 0;
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator>=">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 334,
 FQN="clang::operator>=", NM="_ZN5clanggeENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanggeENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $greatereq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return DeclarationName.compare(/*NO_COPY*/LHS, /*NO_COPY*/RHS) >= 0;
}


/// Insertion operator for diagnostics.  This allows sending DeclarationName's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 549,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_DeclarationName(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                        DeclarationName N) {
  DB.AddTaggedVal(N.getAsOpaqueInteger(), 
      DiagnosticsEngine.ArgumentKind.ak_declarationname);
  return DB;
}


/// Insertion operator for partial diagnostics.  This allows binding
/// DeclarationName's into a partial diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 558,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_DeclarationName(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                        DeclarationName N) {
  PD.AddTaggedVal(N.getAsOpaqueInteger(), 
      DiagnosticsEngine.ArgumentKind.ak_declarationname);
  return PD;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 565,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_DeclarationNameInfo(final raw_ostream /*&*/ OS, 
                                    DeclarationNameInfo DNInfo) {
  DNInfo.printName(OS);
  return OS;
}

} // END OF class DeclarationNameClangGlobals
