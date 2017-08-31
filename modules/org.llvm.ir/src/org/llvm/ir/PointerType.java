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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;


/// Class to represent pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 443,
 FQN="llvm::PointerType", NM="_ZN4llvm11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerTypeE")
//</editor-fold>
public class PointerType extends /*public*/ SequentialType {
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::PointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 444,
   FQN="llvm::PointerType::PointerType", NM="_ZN4llvm11PointerTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerTypeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ PointerType(final /*const*/ PointerType /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 445,
   FQN="llvm::PointerType::operator=", NM="_ZN4llvm11PointerTypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerTypeaSERKS0_")
  //</editor-fold>
  protected/*private*/ /*const*/ PointerType /*&*/ $assign(final /*const*/ PointerType /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::PointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 675,
   FQN="llvm::PointerType::PointerType", NM="_ZN4llvm11PointerTypeC1EPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerTypeC1EPNS_4TypeEj")
  //</editor-fold>
  private PointerType(Type /*P*/ E, /*uint*/int AddrSpace) {
    // : SequentialType(PointerTyID, E)
    //START JInit
    super(TypeID.PointerTyID, E);
    //END JInit
    /*const*//*uint*/int oldNCT = NumContainedTys;
    setSubclassData(AddrSpace);
    // Check for miscompile. PR11652.
    assert (oldNCT == NumContainedTys) : "bitfield written out of bounds?";
  }

/*public:*/
  /// This constructs a pointer to an object of the specified type in a numbered
  /// address space.

  //===----------------------------------------------------------------------===//
  //                         PointerType Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 659,
   FQN="llvm::PointerType::get", NM="_ZN4llvm11PointerType3getEPNS_4TypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerType3getEPNS_4TypeEj")
  //</editor-fold>
  public static PointerType /*P*/ get(Type /*P*/ EltTy, /*uint*/int AddressSpace) {
    assert ((EltTy != null)) : "Can't get a pointer to <null> type!";
    assert (isValidElementType(EltTy)) : "Invalid type for pointer element!";

    LLVMContextImpl /*P*/ CImpl = EltTy.getContext().pImpl;

    // Since AddressSpace #0 is the common case, we special case it.
    //final type$ref<PointerType /*P*/ /*&*/> Entry = (AddressSpace == 0) ? CImpl.PointerTypes.$at_T1$C$R(EltTy) : CImpl.ASPointerTypes.$at_T1$RR(std.make_pair_Ptr_uint(EltTy, AddressSpace));
    final type$ref<PointerType /*P*/ /*&*/> Entry = (AddressSpace == 0) ? CImpl.PointerTypes.ref$at_T1$C$R(EltTy) : CImpl.ASPointerTypes.ref$at_T1$C$R(std.make_pair_Ptr_uint(EltTy, AddressSpace));
    if (!(Entry.$deref() != null)) {
      type$ptr $Mem = CImpl.TypeAllocator.Allocate$JavaRef(1);

      Entry.$set(((/*JCast*/PointerType /*P*/ ) //(/*NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
      /*CImpl.TypeAllocator =*/ /*new (CImpl->TypeAllocator)*/ $new_uint_BumpPtrAllocatorImpl$AllocatorT$SlabSize$SizeThreshold(CImpl.TypeAllocator, (type$ptr<?> New$Mem)->{
          return new PointerType(EltTy, AddressSpace);
       })));
    }
    return Entry.$deref();
  }


  /// This constructs a pointer to an object of the specified type in the
  /// generic address space (address space zero).
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::getUnqual">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 455,
   FQN="llvm::PointerType::getUnqual", NM="_ZN4llvm11PointerType9getUnqualEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerType9getUnqualEPNS_4TypeE")
  //</editor-fold>
  public static PointerType /*P*/ getUnqual(Type /*P*/ ElementType) {
    return PointerType.get(ElementType, 0);
  }


  /// Return true if the specified type is valid as a element type.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::isValidElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 689,
   FQN="llvm::PointerType::isValidElementType", NM="_ZN4llvm11PointerType18isValidElementTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerType18isValidElementTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isValidElementType(Type /*P*/ ElemTy) {
    return !ElemTy.isVoidTy() && !ElemTy.isLabelTy()
       && !ElemTy.isMetadataTy() && !ElemTy.isTokenTy();
  }


  /// Return true if we can load or store from a pointer to this type.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::isLoadableOrStorableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 694,
   FQN="llvm::PointerType::isLoadableOrStorableType", NM="_ZN4llvm11PointerType24isLoadableOrStorableTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerType24isLoadableOrStorableTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isLoadableOrStorableType(Type /*P*/ ElemTy) {
    return isValidElementType(ElemTy) && !ElemTy.isFunctionTy();
  }


  /// Return the address space of the Pointer type.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::getAddressSpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 466,
   FQN="llvm::PointerType::getAddressSpace", NM="_ZNK4llvm11PointerType15getAddressSpaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm11PointerType15getAddressSpaceEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getAddressSpace() /*const*/ {
    return getSubclassData();
  }


  /// Implement support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::PointerType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 469,
   FQN="llvm::PointerType::classof", NM="_ZN4llvm11PointerType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm11PointerType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.PointerTyID;
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
