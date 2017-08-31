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


/// PointerType - C99 6.7.5.1 - Pointer Declarators.
///
//<editor-fold defaultstate="collapsed" desc="clang::PointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2179,
 FQN="clang::PointerType", NM="_ZN5clang11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11PointerTypeE")
//</editor-fold>
public class PointerType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType PointeeType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::PointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2182,
   FQN="clang::PointerType::PointerType", NM="_ZN5clang11PointerTypeC1ENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11PointerTypeC1ENS_8QualTypeES1_")
  //</editor-fold>
  /*friend*//*private*/ PointerType(QualType Pointee, QualType CanonicalPtr) {
    // : Type(Pointer, CanonicalPtr, Pointee->isDependentType(), Pointee->isInstantiationDependentType(), Pointee->isVariablyModifiedType(), Pointee->containsUnexpandedParameterPack()), FoldingSetNode(), PointeeType(Pointee) 
    //START JInit
    super(TypeClass.Pointer, new QualType(CanonicalPtr), Pointee.$arrow().isDependentType(), 
        Pointee.$arrow().isInstantiationDependentType(), 
        Pointee.$arrow().isVariablyModifiedType(), 
        Pointee.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.PointeeType = new QualType(Pointee);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2193,
   FQN="clang::PointerType::getPointeeType", NM="_ZNK5clang11PointerType14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11PointerType14getPointeeTypeEv")
  //</editor-fold>
  public QualType getPointeeType() /*const*/ {
    return new QualType(PointeeType);
  }

  
  /// Returns true if address spaces of pointers overlap.
  /// OpenCL v2.0 defines conversion rules for pointers to different
  /// address spaces (OpenCLC v2.0 s6.5.5) and notion of overlapping
  /// address spaces.
  /// CL1.1 or CL1.2:
  ///   address spaces overlap iff they are they same.
  /// CL2.0 adds:
  ///   __generic overlaps with any address space except for __constant.
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::isAddressSpaceOverlapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2203,
   FQN="clang::PointerType::isAddressSpaceOverlapping", NM="_ZNK5clang11PointerType25isAddressSpaceOverlappingERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11PointerType25isAddressSpaceOverlappingERKS0_")
  //</editor-fold>
  public boolean isAddressSpaceOverlapping(final /*const*/ PointerType /*&*/ other) /*const*/ {
    Qualifiers thisQuals = PointeeType.getQualifiers();
    Qualifiers otherQuals = other.getPointeeType().getQualifiers();
    // Address spaces overlap if at least one of them is a superset of another
    return thisQuals.isAddressSpaceSupersetOf(new Qualifiers(otherQuals))
       || otherQuals.isAddressSpaceSupersetOf(new Qualifiers(thisQuals));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2211,
   FQN="clang::PointerType::isSugared", NM="_ZNK5clang11PointerType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11PointerType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2212,
   FQN="clang::PointerType::desugar", NM="_ZNK5clang11PointerType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang11PointerType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2214,
   FQN="clang::PointerType::Profile", NM="_ZN5clang11PointerType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11PointerType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getPointeeType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2217,
   FQN="clang::PointerType::Profile", NM="_ZN5clang11PointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11PointerType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Pointee) {
    ID.AddPointer(Pointee.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PointerType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2221,
   FQN="clang::PointerType::classof", NM="_ZN5clang11PointerType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang11PointerType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Pointer;
  }

  @Override public String toString() {
    return "" + "PointeeType=" + PointeeType // NOI18N
              + super.toString(); // NOI18N
  }
}
