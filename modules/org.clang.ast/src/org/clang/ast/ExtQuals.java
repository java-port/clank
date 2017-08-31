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


/// We can encode up to four bits in the low bits of a
/// type pointer, but there are many more type qualifiers that we want
/// to be able to apply to an arbitrary type.  Therefore we have this
/// struct, intended to be heap-allocated and used by QualType to
/// store qualifiers.
///
/// The current design tags the 'const', 'restrict', and 'volatile' qualifiers
/// in three low bits on the QualType pointer; a fourth bit records whether
/// the pointer is an ExtQuals node. The extended qualifiers (address spaces,
/// Objective-C GC attributes) are much more rare.
//<editor-fold defaultstate="collapsed" desc="clang::ExtQuals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1173,
 FQN="clang::ExtQuals", NM="_ZN5clang8ExtQualsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8ExtQualsE")
//</editor-fold>
public class ExtQuals extends /*public*/ ExtQualsTypeCommonBase implements /*public*/ FoldingSetImpl.Node {
  // NOTE: changing the fast qualifiers should be straightforward as
  // long as you don't make 'const' non-fast.
  // 1. Qualifiers:
  //    a) Modify the bitmasks (Qualifiers::TQ and DeclSpec::TQ).
  //       Fast qualifiers must occupy the low-order bits.
  //    b) Update Qualifiers::FastWidth and FastMask.
  // 2. QualType:
  //    a) Update is{Volatile,Restrict}Qualified(), defined inline.
  //    b) Update remove{Volatile,Restrict}, defined near the end of
  //       this header.
  // 3. ASTContext:
  //    a) Update get{Volatile,Restrict}Type.
  
  /// The immutable set of qualifiers applied by this node. Always contains
  /// extended qualifiers.
  private Qualifiers Quals;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::this_">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1191,
   FQN="clang::ExtQuals::this_", NM="_ZN5clang8ExtQuals5this_Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8ExtQuals5this_Ev")
  //</editor-fold>
  private ExtQuals /*P*/ this_() {
    return this;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::ExtQuals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1194,
   FQN="clang::ExtQuals::ExtQuals", NM="_ZN5clang8ExtQualsC1EPKNS_4TypeENS_8QualTypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8ExtQualsC1EPKNS_4TypeENS_8QualTypeENS_10QualifiersE")
  //</editor-fold>
  public ExtQuals(/*const*/ Type /*P*/ baseType, QualType canon, Qualifiers quals) {
    // : ExtQualsTypeCommonBase(baseType, canon.isNull() ? QualType(this_(), 0) : canon), FoldingSetNode(), Quals(quals) 
    //START JInit
    super();
    $ExtQuals(baseType, canon, quals);
  }
  protected void $ExtQuals(/*const*/ Type /*P*/ baseType, QualType canon, Qualifiers quals) {
    // : ExtQualsTypeCommonBase(baseType, canon.isNull() ? QualType(this_(), 0) : canon), FoldingSetNode(), Quals(quals) 
    //START JInit
    $ExtQualsTypeCommonBase(baseType, 
        canon.isNull() ? new QualType(this_(), 0) : new QualType(canon));
    $Node();
    this.Quals = new Qualifiers(quals);
    //END JInit
    assert (Quals.hasNonFastQualifiers()) : "ExtQuals created with no fast qualifiers";
    assert (!Quals.hasFastQualifiers()) : "ExtQuals created with fast qualifiers";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::getQualifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1205,
   FQN="clang::ExtQuals::getQualifiers", NM="_ZNK5clang8ExtQuals13getQualifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals13getQualifiersEv")
  //</editor-fold>
  public Qualifiers getQualifiers() /*const*/ {
    return new Qualifiers(Quals);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::hasObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1207,
   FQN="clang::ExtQuals::hasObjCGCAttr", NM="_ZNK5clang8ExtQuals13hasObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals13hasObjCGCAttrEv")
  //</editor-fold>
  public boolean hasObjCGCAttr() /*const*/ {
    return Quals.hasObjCGCAttr();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::getObjCGCAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1208,
   FQN="clang::ExtQuals::getObjCGCAttr", NM="_ZNK5clang8ExtQuals13getObjCGCAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals13getObjCGCAttrEv")
  //</editor-fold>
  public Qualifiers.GC getObjCGCAttr() /*const*/ {
    return Quals.getObjCGCAttr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::hasObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1210,
   FQN="clang::ExtQuals::hasObjCLifetime", NM="_ZNK5clang8ExtQuals15hasObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals15hasObjCLifetimeEv")
  //</editor-fold>
  public boolean hasObjCLifetime() /*const*/ {
    return Quals.hasObjCLifetime();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::getObjCLifetime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1211,
   FQN="clang::ExtQuals::getObjCLifetime", NM="_ZNK5clang8ExtQuals15getObjCLifetimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals15getObjCLifetimeEv")
  //</editor-fold>
  public Qualifiers.ObjCLifetime getObjCLifetime() /*const*/ {
    return Quals.getObjCLifetime();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::hasAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1215,
   FQN="clang::ExtQuals::hasAddressSpace", NM="_ZNK5clang8ExtQuals15hasAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals15hasAddressSpaceEv")
  //</editor-fold>
  public boolean hasAddressSpace() /*const*/ {
    return Quals.hasAddressSpace();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1216,
   FQN="clang::ExtQuals::getAddressSpace", NM="_ZNK5clang8ExtQuals15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals15getAddressSpaceEv")
  //</editor-fold>
  public /*uint*/int getAddressSpace() /*const*/ {
    return Quals.getAddressSpace();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::getBaseType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1218,
   FQN="clang::ExtQuals::getBaseType", NM="_ZNK5clang8ExtQuals11getBaseTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals11getBaseTypeEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getBaseType() /*const*/ {
    return BaseType;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1221,
   FQN="clang::ExtQuals::Profile", NM="_ZNK5clang8ExtQuals7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang8ExtQuals7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, getBaseType(), /*NO_COPY*/Quals);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ExtQuals::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 1224,
   FQN="clang::ExtQuals::Profile", NM="_ZN5clang8ExtQuals7ProfileERN4llvm16FoldingSetNodeIDEPKNS_4TypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang8ExtQuals7ProfileERN4llvm16FoldingSetNodeIDEPKNS_4TypeENS_10QualifiersE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         /*const*/ Type /*P*/ BaseType, 
         Qualifiers Quals) {
    assert (!Quals.hasFastQualifiers()) : "fast qualifiers in ExtQuals hash!";
    ID.AddPointer(BaseType);
    Quals.Profile(ID);
  }

  
  @Override public String toString() {
    return "" + "Quals=" + Quals // NOI18N
              + super.toString(); // NOI18N
  }
}
