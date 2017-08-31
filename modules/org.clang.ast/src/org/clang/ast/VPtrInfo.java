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
import org.llvm.adt.aliases.*;


/// Holds information about the inheritance path to a virtual base or function
/// table pointer.  A record may contain as many vfptrs or vbptrs as there are
/// base subobjects.
//<editor-fold defaultstate="collapsed" desc="clang::VPtrInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 398,
 FQN="clang::VPtrInfo", NM="_ZN5clang8VPtrInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang8VPtrInfoE")
//</editor-fold>
public class/*struct*/ VPtrInfo implements Destructors.ClassWithDestructor {
  /*typedef SmallVector<const CXXRecordDecl *, 1> BasePath*/
//  public final class BasePath extends SmallVector</*const*/ CXXRecordDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::VPtrInfo::VPtrInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 401,
   FQN="clang::VPtrInfo::VPtrInfo", NM="_ZN5clang8VPtrInfoC1EPKNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang8VPtrInfoC1EPKNS_13CXXRecordDeclE")
  //</editor-fold>
  public VPtrInfo(/*const*/ CXXRecordDecl /*P*/ RD) {
    // : ReusingBase(RD), NonVirtualOffset(), BaseWithVPtr(RD), MangledPath(), NextBaseToMangle(RD), ContainingVBases(), PathToBaseWithVPtr(), FullOffsetInMDC() 
    //START JInit
    this.ReusingBase = RD;
    this.NonVirtualOffset = new CharUnits();
    this.BaseWithVPtr = RD;
    this.MangledPath = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(1, (/*const*/ CXXRecordDecl /*P*/ )null);
    this.NextBaseToMangle = RD;
    this.ContainingVBases = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(1, (/*const*/ CXXRecordDecl /*P*/ )null);
    this.PathToBaseWithVPtr = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(1, (/*const*/ CXXRecordDecl /*P*/ )null);
    this.FullOffsetInMDC = new CharUnits();
    //END JInit
  }

  
  /// The vtable will hold all of the virtual bases or virtual methods of
  /// ReusingBase.  This may or may not be the same class as VPtrSubobject.Base.
  /// A derived class will reuse the vptr of the first non-virtual base
  /// subobject that has one.
  public /*const*/ CXXRecordDecl /*P*/ ReusingBase;
  
  /// BaseWithVPtr is at this offset from its containing complete object or
  /// virtual base.
  public CharUnits NonVirtualOffset;
  
  /// The vptr is stored inside this subobject.
  public /*const*/ CXXRecordDecl /*P*/ BaseWithVPtr;
  
  /// The bases from the inheritance path that got used to mangle the vbtable
  /// name.  This is not really a full path like a CXXBasePath.  It holds the
  /// subset of records that need to be mangled into the vbtable symbol name in
  /// order to get a unique name.
  public SmallVector</*const*/ CXXRecordDecl /*P*/ > MangledPath;
  
  /// The next base to push onto the mangled path if this path is ambiguous in a
  /// derived class.  If it's null, then it's already been pushed onto the path.
  public /*const*/ CXXRecordDecl /*P*/ NextBaseToMangle;
  
  /// The set of possibly indirect vbases that contain this vbtable.  When a
  /// derived class indirectly inherits from the same vbase twice, we only keep
  /// vtables and their paths from the first instance.
  public SmallVector</*const*/ CXXRecordDecl /*P*/ > ContainingVBases;
  
  /// This holds the base classes path from the complete type to the first base
  /// with the given vfptr offset, in the base-to-derived order.  Only used for
  /// vftables.
  public SmallVector</*const*/ CXXRecordDecl /*P*/ > PathToBaseWithVPtr;
  
  /// Static offset from the top of the most derived class to this vfptr,
  /// including any virtual base offset.  Only used for vftables.
  public CharUnits FullOffsetInMDC;
  
  /// The vptr is stored inside the non-virtual component of this virtual base.
  //<editor-fold defaultstate="collapsed" desc="clang::VPtrInfo::getVBaseWithVPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 442,
   FQN="clang::VPtrInfo::getVBaseWithVPtr", NM="_ZNK5clang8VPtrInfo16getVBaseWithVPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZNK5clang8VPtrInfo16getVBaseWithVPtrEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getVBaseWithVPtr() /*const*/ {
    return ContainingVBases.empty() ? null : ContainingVBases.front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VPtrInfo::VPtrInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 398,
   FQN="clang::VPtrInfo::VPtrInfo", NM="_ZN5clang8VPtrInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang8VPtrInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ VPtrInfo(final /*const*/ VPtrInfo /*&*/ $Prm0) {
    // : ReusingBase(.ReusingBase), NonVirtualOffset(.NonVirtualOffset), BaseWithVPtr(.BaseWithVPtr), MangledPath(.MangledPath), NextBaseToMangle(.NextBaseToMangle), ContainingVBases(.ContainingVBases), PathToBaseWithVPtr(.PathToBaseWithVPtr), FullOffsetInMDC(.FullOffsetInMDC) 
    //START JInit
    this.ReusingBase = $Prm0.ReusingBase;
    this.NonVirtualOffset = new CharUnits($Prm0.NonVirtualOffset);
    this.BaseWithVPtr = $Prm0.BaseWithVPtr;
    this.MangledPath = new SmallVector</*const*/ CXXRecordDecl /*P*/ >($Prm0.MangledPath);
    this.NextBaseToMangle = $Prm0.NextBaseToMangle;
    this.ContainingVBases = new SmallVector</*const*/ CXXRecordDecl /*P*/ >($Prm0.ContainingVBases);
    this.PathToBaseWithVPtr = new SmallVector</*const*/ CXXRecordDecl /*P*/ >($Prm0.PathToBaseWithVPtr);
    this.FullOffsetInMDC = new CharUnits($Prm0.FullOffsetInMDC);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VPtrInfo::~VPtrInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/VTableBuilder.h", line = 398,
   FQN="clang::VPtrInfo::~VPtrInfo", NM="_ZN5clang8VPtrInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN5clang8VPtrInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PathToBaseWithVPtr.$destroy();
    ContainingVBases.$destroy();
    MangledPath.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ReusingBase=" + ReusingBase // NOI18N
              + ", NonVirtualOffset=" + NonVirtualOffset // NOI18N
              + ", BaseWithVPtr=" + BaseWithVPtr // NOI18N
              + ", MangledPath=" + MangledPath // NOI18N
              + ", NextBaseToMangle=" + NextBaseToMangle // NOI18N
              + ", ContainingVBases=" + ContainingVBases // NOI18N
              + ", PathToBaseWithVPtr=" + PathToBaseWithVPtr // NOI18N
              + ", FullOffsetInMDC=" + FullOffsetInMDC; // NOI18N
  }
}
