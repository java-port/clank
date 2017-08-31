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
import org.llvm.adt.*;


/// A pointer to member type per C++ 8.3.3 - Pointers to members.
///
/// This includes both pointers to data members and pointer to member functions.
///
//<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2401,
 FQN="clang::MemberPointerType", NM="_ZN5clang17MemberPointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17MemberPointerTypeE")
//</editor-fold>
public class MemberPointerType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType PointeeType;
  /// The class of which the pointee is a member. Must ultimately be a
  /// RecordType, but could be a typedef or a template parameter too.
  private /*const*/ Type /*P*/ Class;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::MemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2407,
   FQN="clang::MemberPointerType::MemberPointerType", NM="_ZN5clang17MemberPointerTypeC1ENS_8QualTypeEPKNS_4TypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17MemberPointerTypeC1ENS_8QualTypeEPKNS_4TypeES1_")
  //</editor-fold>
  /*friend*//*package*/ MemberPointerType(QualType Pointee, /*const*/ Type /*P*/ Cls, QualType CanonicalPtr) {
    // : Type(MemberPointer, CanonicalPtr, Cls->isDependentType() || Pointee->isDependentType(), (Cls->isInstantiationDependentType() || Pointee->isInstantiationDependentType()), Pointee->isVariablyModifiedType(), (Cls->containsUnexpandedParameterPack() || Pointee->containsUnexpandedParameterPack())), FoldingSetNode(), PointeeType(Pointee), Class(Cls) 
    //START JInit
    super(TypeClass.MemberPointer, new QualType(CanonicalPtr), 
        Cls.isDependentType() || Pointee.$arrow().isDependentType(), 
        (Cls.isInstantiationDependentType()
           || Pointee.$arrow().isInstantiationDependentType()), 
        Pointee.$arrow().isVariablyModifiedType(), 
        (Cls.containsUnexpandedParameterPack()
           || Pointee.$arrow().containsUnexpandedParameterPack()));
    $Node();
    this.PointeeType = new QualType(Pointee);
    this.Class = Cls;
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2420,
   FQN="clang::MemberPointerType::getPointeeType", NM="_ZNK5clang17MemberPointerType14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType14getPointeeTypeEv")
  //</editor-fold>
  public QualType getPointeeType() /*const*/ {
    return new QualType(PointeeType);
  }

  
  /// Returns true if the member type (i.e. the pointee type) is a
  /// function type rather than a data-member type.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::isMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2424,
   FQN="clang::MemberPointerType::isMemberFunctionPointer", NM="_ZNK5clang17MemberPointerType23isMemberFunctionPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType23isMemberFunctionPointerEv")
  //</editor-fold>
  public boolean isMemberFunctionPointer() /*const*/ {
    return PointeeType.$arrow().isFunctionProtoType();
  }

  
  /// Returns true if the member type (i.e. the pointee type) is a
  /// data type rather than a function type.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::isMemberDataPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2430,
   FQN="clang::MemberPointerType::isMemberDataPointer", NM="_ZNK5clang17MemberPointerType19isMemberDataPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType19isMemberDataPointerEv")
  //</editor-fold>
  public boolean isMemberDataPointer() /*const*/ {
    return !PointeeType.$arrow().isFunctionProtoType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::getClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2434,
   FQN="clang::MemberPointerType::getClass", NM="_ZNK5clang17MemberPointerType8getClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType8getClassEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ __getClass() /*const*/ {
    return Class;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::getMostRecentCXXRecordDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3782,
   FQN="clang::MemberPointerType::getMostRecentCXXRecordDecl", NM="_ZNK5clang17MemberPointerType26getMostRecentCXXRecordDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType26getMostRecentCXXRecordDeclEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getMostRecentCXXRecordDecl() /*const*/ {
    return __getClass().getAsCXXRecordDecl().getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2437,
   FQN="clang::MemberPointerType::isSugared", NM="_ZNK5clang17MemberPointerType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2438,
   FQN="clang::MemberPointerType::desugar", NM="_ZNK5clang17MemberPointerType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17MemberPointerType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2440,
   FQN="clang::MemberPointerType::Profile", NM="_ZN5clang17MemberPointerType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17MemberPointerType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getPointeeType(), __getClass());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2443,
   FQN="clang::MemberPointerType::Profile", NM="_ZN5clang17MemberPointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17MemberPointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEPKNS_4TypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Pointee, 
         /*const*/ Type /*P*/ Class) {
    ID.AddPointer(Pointee.getAsOpaquePtr());
    ID.AddPointer(Class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberPointerType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2449,
   FQN="clang::MemberPointerType::classof", NM="_ZN5clang17MemberPointerType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17MemberPointerType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.MemberPointer;
  }

  @Override public String toString() {
    return "" + "PointeeType=" + PointeeType // NOI18N
              + ", Class=" + Class // NOI18N
              + super.toString(); // NOI18N
  }
}
