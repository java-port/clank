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

package org.clang.ast;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 180,
 FQN="clang::MicrosoftMangleContext", NM="_ZN5clang22MicrosoftMangleContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContextE")
//</editor-fold>
public abstract class MicrosoftMangleContext extends /*public*/ MangleContext implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::MicrosoftMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 182,
   FQN="clang::MicrosoftMangleContext::MicrosoftMangleContext", NM="_ZN5clang22MicrosoftMangleContextC1ERNS_10ASTContextERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContextC1ERNS_10ASTContextERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public /*explicit*/ MicrosoftMangleContext(final ASTContext /*&*/ C, final DiagnosticsEngine /*&*/ D) {
    // : MangleContext(C, D, MK_Microsoft) 
    //START JInit
    super(C, D, ManglerKind.MK_Microsoft);
    //END JInit
  }

  
  /// \brief Mangle vftable symbols.  Only a subset of the bases along the path
  /// to the vftable are included in the name.  It's up to the caller to pick
  /// them correctly.
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXVFTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 188,
   FQN="clang::MicrosoftMangleContext::mangleCXXVFTable", NM="_ZN5clang22MicrosoftMangleContext16mangleCXXVFTableEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext16mangleCXXVFTableEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXVFTable(/*const*/ CXXRecordDecl /*P*/ Derived, 
                  ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                  final raw_ostream /*&*/ Out)/* = 0*/;

  
  /// \brief Mangle vbtable symbols.  Only a subset of the bases along the path
  /// to the vbtable are included in the name.  It's up to the caller to pick
  /// them correctly.
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXVBTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 195,
   FQN="clang::MicrosoftMangleContext::mangleCXXVBTable", NM="_ZN5clang22MicrosoftMangleContext16mangleCXXVBTableEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext16mangleCXXVBTableEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXVBTable(/*const*/ CXXRecordDecl /*P*/ Derived, 
                  ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                  final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleThreadSafeStaticGuardVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 199,
   FQN="clang::MicrosoftMangleContext::mangleThreadSafeStaticGuardVariable", NM="_ZN5clang22MicrosoftMangleContext35mangleThreadSafeStaticGuardVariableEPKNS_7VarDeclEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext35mangleThreadSafeStaticGuardVariableEPKNS_7VarDeclEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleThreadSafeStaticGuardVariable(/*const*/ VarDecl /*P*/ VD, 
                                     /*uint*/int GuardNum, 
                                     final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleVirtualMemPtrThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 203,
   FQN="clang::MicrosoftMangleContext::mangleVirtualMemPtrThunk", NM="_ZN5clang22MicrosoftMangleContext24mangleVirtualMemPtrThunkEPKNS_13CXXMethodDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext24mangleVirtualMemPtrThunkEPKNS_13CXXMethodDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleVirtualMemPtrThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
                          final raw_ostream /*&*/ $Prm1)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXVirtualDisplacementMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 206,
   FQN="clang::MicrosoftMangleContext::mangleCXXVirtualDisplacementMap", NM="_ZN5clang22MicrosoftMangleContext31mangleCXXVirtualDisplacementMapEPKNS_13CXXRecordDeclES3_RN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext31mangleCXXVirtualDisplacementMapEPKNS_13CXXRecordDeclES3_RN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXVirtualDisplacementMap(/*const*/ CXXRecordDecl /*P*/ SrcRD, 
                                 /*const*/ CXXRecordDecl /*P*/ DstRD, 
                                 final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXThrowInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 210,
   FQN="clang::MicrosoftMangleContext::mangleCXXThrowInfo", NM="_ZN5clang22MicrosoftMangleContext18mangleCXXThrowInfoENS_8QualTypeEbbbjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext18mangleCXXThrowInfoENS_8QualTypeEbbbjRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXThrowInfo(QualType T, boolean IsConst, boolean IsVolatile, 
                    boolean IsUnaligned, /*uint32_t*/int NumEntries, 
                    final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXCatchableTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 214,
   FQN="clang::MicrosoftMangleContext::mangleCXXCatchableTypeArray", NM="_ZN5clang22MicrosoftMangleContext27mangleCXXCatchableTypeArrayENS_8QualTypeEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext27mangleCXXCatchableTypeArrayENS_8QualTypeEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXCatchableTypeArray(QualType T, /*uint32_t*/int NumEntries, 
                             final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXCatchableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 217,
   FQN="clang::MicrosoftMangleContext::mangleCXXCatchableType", NM="_ZN5clang22MicrosoftMangleContext22mangleCXXCatchableTypeENS_8QualTypeEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEjjijRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext22mangleCXXCatchableTypeENS_8QualTypeEPKNS_18CXXConstructorDeclENS_11CXXCtorTypeEjjijRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXCatchableType(QualType T, /*const*/ CXXConstructorDecl /*P*/ CD, 
                        CXXCtorType CT, /*uint32_t*/int Size, 
                        /*uint32_t*/int NVOffset, int/*int32_t*/ VBPtrOffset, 
                        /*uint32_t*/int VBIndex, final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXRTTIBaseClassDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 222,
   FQN="clang::MicrosoftMangleContext::mangleCXXRTTIBaseClassDescriptor", NM="_ZN5clang22MicrosoftMangleContext32mangleCXXRTTIBaseClassDescriptorEPKNS_13CXXRecordDeclEjijjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext32mangleCXXRTTIBaseClassDescriptorEPKNS_13CXXRecordDeclEjijjRN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTIBaseClassDescriptor(/*const*/ CXXRecordDecl /*P*/ Derived, /*uint32_t*/int NVOffset, int/*int32_t*/ VBPtrOffset, 
                                  /*uint32_t*/int VBTableOffset, /*uint32_t*/int Flags, final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXRTTIBaseClassArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 226,
   FQN="clang::MicrosoftMangleContext::mangleCXXRTTIBaseClassArray", NM="_ZN5clang22MicrosoftMangleContext27mangleCXXRTTIBaseClassArrayEPKNS_13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext27mangleCXXRTTIBaseClassArrayEPKNS_13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTIBaseClassArray(/*const*/ CXXRecordDecl /*P*/ Derived, 
                             final raw_ostream /*&*/ Out)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXRTTIClassHierarchyDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 228,
   FQN="clang::MicrosoftMangleContext::mangleCXXRTTIClassHierarchyDescriptor", NM="_ZN5clang22MicrosoftMangleContext37mangleCXXRTTIClassHierarchyDescriptorEPKNS_13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext37mangleCXXRTTIClassHierarchyDescriptorEPKNS_13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTIClassHierarchyDescriptor(/*const*/ CXXRecordDecl /*P*/ Derived, 
                                       final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::mangleCXXRTTICompleteObjectLocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 232,
   FQN="clang::MicrosoftMangleContext::mangleCXXRTTICompleteObjectLocator", NM="_ZN5clang22MicrosoftMangleContext34mangleCXXRTTICompleteObjectLocatorEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext34mangleCXXRTTICompleteObjectLocatorEPKNS_13CXXRecordDeclEN4llvm8ArrayRefIS3_EERNS4_11raw_ostreamE")
  //</editor-fold>
  public abstract /*virtual*/ void mangleCXXRTTICompleteObjectLocator(/*const*/ CXXRecordDecl /*P*/ Derived, 
                                    ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                                    final raw_ostream /*&*/ Out)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 237,
   FQN="clang::MicrosoftMangleContext::classof", NM="_ZN5clang22MicrosoftMangleContext7classofEPKNS_13MangleContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext7classofEPKNS_13MangleContextE")
  //</editor-fold>
  public static boolean classof(/*const*/ MangleContext /*P*/ C) {
    return C.getKind() == ManglerKind.MK_Microsoft;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 3023,
   FQN="clang::MicrosoftMangleContext::create", NM="_ZN5clang22MicrosoftMangleContext6createERNS_10ASTContextERNS_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContext6createERNS_10ASTContextERNS_17DiagnosticsEngineE")
  //</editor-fold>
  public static MicrosoftMangleContext /*P*/ create(final ASTContext /*&*/ Context, final DiagnosticsEngine /*&*/ Diags) {
    return new MicrosoftMangleContextImpl(Context, Diags);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MicrosoftMangleContext::~MicrosoftMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Mangle.h", line = 180,
   FQN="clang::MicrosoftMangleContext::~MicrosoftMangleContext", NM="_ZN5clang22MicrosoftMangleContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN5clang22MicrosoftMangleContextD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
