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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExpansion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 800,
 FQN="(anonymous namespace)::RecordExpansion", NM="_ZN12_GLOBAL__N_115RecordExpansionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_115RecordExpansionE")
//</editor-fold>
public class/*struct*/ RecordExpansion extends /**/ TypeExpansion implements Destructors.ClassWithDestructor {
  public SmallVector</*const*/ CXXBaseSpecifier /*P*/ > Bases;
  
  public SmallVector</*const*/ FieldDecl /*P*/ > Fields;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExpansion::RecordExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 805,
   FQN="(anonymous namespace)::RecordExpansion::RecordExpansion", NM="_ZN12_GLOBAL__N_115RecordExpansionC1EON4llvm11SmallVectorIPKN5clang16CXXBaseSpecifierELj1EEEONS2_IPKNS3_9FieldDeclELj1EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_115RecordExpansionC1EON4llvm11SmallVectorIPKN5clang16CXXBaseSpecifierELj1EEEONS2_IPKNS3_9FieldDeclELj1EEE")
  //</editor-fold>
  public RecordExpansion(final SmallVector</*const*/ CXXBaseSpecifier /*P*/ > /*&*/ Bases, 
      final SmallVector</*const*/ FieldDecl /*P*/ > /*&*/ Fields) {
    // : TypeExpansion(TEK_Record), Bases(std::move(Bases)), Fields(std::move(Fields)) 
    //START JInit
    super(TypeExpansionKind.TEK_Record);
    this.Bases = new SmallVector</*const*/ CXXBaseSpecifier /*P*/ >(JD$Move.INSTANCE, std.move(Bases));
    this.Fields = new SmallVector</*const*/ FieldDecl /*P*/ >(JD$Move.INSTANCE, std.move(Fields));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExpansion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 809,
   FQN="(anonymous namespace)::RecordExpansion::classof", NM="_ZN12_GLOBAL__N_115RecordExpansion7classofEPKNS_13TypeExpansionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_115RecordExpansion7classofEPKNS_13TypeExpansionE")
  //</editor-fold>
  public static boolean classof(/*const*/ TypeExpansion /*P*/ TE) {
    return TE.Kind == TypeExpansionKind.TEK_Record;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RecordExpansion::~RecordExpansion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp", line = 800,
   FQN="(anonymous namespace)::RecordExpansion::~RecordExpansion", NM="_ZN12_GLOBAL__N_115RecordExpansionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN12_GLOBAL__N_115RecordExpansionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Fields.$destroy();
    Bases.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Bases=" + Bases // NOI18N
              + ", Fields=" + "[SmallVector$FieldDecl]" // NOI18N
              + super.toString(); // NOI18N
  }
}
