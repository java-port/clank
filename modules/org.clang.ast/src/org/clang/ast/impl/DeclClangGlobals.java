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
import static org.clank.support.Casts.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE;_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE;_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE;_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE; -static-type=DeclClangGlobals -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclClangGlobals {


/// \brief Get the primary declaration for a declaration from an AST file. That
/// will be the first-loaded declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getPrimaryMergedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 39,
 FQN="clang::getPrimaryMergedDecl", NM="_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE")
//</editor-fold>
public static Decl /*P*/ getPrimaryMergedDecl(Decl /*P*/ D) {
  return D.getASTContext().getPrimaryMergedDecl(D);
}


// Inline function definitions.

/// \brief Check if the given decl is complete.
///
/// We use this function to break a cycle between the inline definitions in
/// Type.h and Decl.h.
//<editor-fold defaultstate="collapsed" desc="clang::IsEnumDeclComplete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3856,
 FQN="clang::IsEnumDeclComplete", NM="_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE")
//</editor-fold>
public static /*inline*/ boolean IsEnumDeclComplete(EnumDecl /*P*/ ED) {
  return ED.isComplete();
}


/// \brief Check if the given decl is scoped.
///
/// We use this function to break a cycle between the inline definitions in
/// Type.h and Decl.h.
//<editor-fold defaultstate="collapsed" desc="clang::IsEnumDeclScoped">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3864,
 FQN="clang::IsEnumDeclScoped", NM="_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE")
//</editor-fold>
public static /*inline*/ boolean IsEnumDeclScoped(EnumDecl /*P*/ ED) {
  return ED.isScoped();
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 414,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_NamedDecl$C(final raw_ostream /*&*/ OS, final /*const*/ NamedDecl /*&*/ ND) {
  ND.printName(OS);
  return OS;
}


/// Insertion operator for diagnostics.  This allows sending NamedDecl's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3804,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_NamedDecl$C$P(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                      /*const*/ NamedDecl /*P*/ ND) {
  DB.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(ND), 
      DiagnosticsEngine.ArgumentKind.ak_nameddecl);
  return DB;
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3810,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_NamedDecl$C$P(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                      /*const*/ NamedDecl /*P*/ ND) {
  PD.AddTaggedVal(reinterpret_cast_Object/*intptr_t*/(ND), 
      DiagnosticsEngine.ArgumentKind.ak_nameddecl);
  return PD;
}

} // END OF class DeclClangGlobals
