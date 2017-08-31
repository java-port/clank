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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;


/// \brief Debug location.
///
/// A debug location in source code, used for debug info and otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::DILocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1172,
 FQN="llvm::DILocation", NM="_ZN4llvm10DILocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocationE")
//</editor-fold>
public class DILocation extends /*public*/ MDNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::DILocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 22,
   FQN="llvm::DILocation::DILocation", NM="_ZN4llvm10DILocationC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocationC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DILocation(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      /*uint*/int Column, ArrayRef<Metadata /*P*/ > MDs) {
    // : MDNode(C, DILocationKind, Storage, MDs)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DILocationKind.getValue(), Storage, new ArrayRef<Metadata /*P*/ >(MDs));
    //END JInit
    assert ((MDs.size() == 1 || MDs.size() == 2)) : "Expected a scope and optional inlined-at";

    // Set line and column.
    assert ($less_uint(Column, (1/*U*/ << 16))) : "Expected 16-bit column";

    SubclassData32 = Line;
    SubclassData16 = $uint2ushort(Column);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::~DILocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1178,
   FQN="llvm::DILocation::~DILocation", NM="_ZN4llvm10DILocationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocationD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy() {
    dropAllReferences();
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 41,
   FQN="llvm::DILocation::getImpl", NM="_ZN4llvm10DILocation7getImplERNS_11LLVMContextEjjPNS_8MetadataES4_NS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation7getImplERNS_11LLVMContextEjjPNS_8MetadataES4_NS3_11StorageTypeEb")
  //</editor-fold>
  private static DILocation /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Line,
         /*uint*/int Column, Metadata /*P*/ Scope,
         Metadata /*P*/ InlinedAt, Metadata.StorageType Storage) {
    return getImpl(Context, Line,
         Column, Scope,
         InlinedAt, Storage,
         true);
  }
  private static DILocation /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Line,
         /*uint*/int Column, Metadata /*P*/ Scope,
         Metadata /*P*/ InlinedAt, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    // Fixup column.
    uint$ref Column$ref = create_uint$ref(Column);
    DebugInfoMetadataStatics.adjustColumn(Column$ref);
    Column = Column$ref.$deref();
    if (Storage == StorageType.Uniqued) {
      {
        DILocation /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DILocations,
            new MDNodeKeyImplDILocation(Line, Column, Scope, InlinedAt));
        if ((N != null)) {
          return N;
        }
      }
      if (!ShouldCreate) {
        return null;
      }
    } else {
      assert (ShouldCreate) : "Expected non-uniqued nodes to always be created";
    }

    SmallVector<Metadata /*P*/ > Ops/*J*/= new SmallVector<Metadata /*P*/ >(2, (Metadata /*P*/ )null);
    Ops.push_back(Scope);
    if ((InlinedAt != null)) {
      Ops.push_back(InlinedAt);
    }
    int Column$final = Column;
    return MDNode.storeImpl(/*NEW_EXPR [MDNode::new]*//*new (Ops.size())*/ MDNode.$new(Ops.size(), (type$ptr<?> New$Mem)->{
            return new DILocation(Context, Storage, Line, Column$final, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }),
        Storage, Context.pImpl.DILocations);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1184,
   FQN="llvm::DILocation::getImpl", NM="_ZN4llvm10DILocation7getImplERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation7getImplERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DILocation /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Line,
         /*uint*/int Column, DILocalScope /*P*/ Scope,
         DILocation /*P*/ InlinedAt, Metadata.StorageType Storage) {
    return getImpl(Context, Line,
         Column, Scope,
         InlinedAt, Storage,
         true);
  }
  private static DILocation /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int Line,
         /*uint*/int Column, DILocalScope /*P*/ Scope,
         DILocation /*P*/ InlinedAt, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return DILocation.getImpl(Context, Line, Column, ((/*static_cast*/Metadata /*P*/ )(Scope)),
        ((/*static_cast*/Metadata /*P*/ )(InlinedAt)), Storage, ShouldCreate);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1192,
   FQN="llvm::DILocation::cloneImpl", NM="_ZNK4llvm10DILocation9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    // Get the raw scope/inlinedAt since it is possible to invoke this on
    // a DILocation containing temporary metadata.
    return DILocation.getTemporary(getContext(), getLine(), getColumn(), getRawScope(),
        getRawInlinedAt());
  }


  // Disallow replacing operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::replaceOperandWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1200,
   FQN="llvm::DILocation::replaceOperandWith", NM="_ZN4llvm10DILocation18replaceOperandWithEjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation18replaceOperandWithEjPNS_8MetadataE")
  //</editor-fold>
  public/*private*/ void replaceOperandWith(/*uint*/int I, Metadata /*P*/ New) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1203,
   FQN="llvm::DILocation::get", NM="_ZN4llvm10DILocation3getERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation3getERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DILocation /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope) {
    return get(Context, Line, Column, Scope, (Metadata /*P*/ )null);
  }
  public static DILocation /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope, Metadata /*P*/ InlinedAt/*= null*/) {
    return getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1203,
   FQN="llvm::DILocation::getIfExists", NM="_ZN4llvm10DILocation11getIfExistsERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation11getIfExistsERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DILocation /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope) {
    return getIfExists(Context, Line, Column, Scope, (Metadata /*P*/ )null);
  }
  public static DILocation /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope, Metadata /*P*/ InlinedAt/*= null*/) {
    return getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1203,
   FQN="llvm::DILocation::getDistinct", NM="_ZN4llvm10DILocation11getDistinctERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation11getDistinctERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DILocation /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope) {
    return getDistinct(Context, Line, Column, Scope, (Metadata /*P*/ )null);
  }
  public static DILocation /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope, Metadata /*P*/ InlinedAt/*= null*/) {
    return getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1203,
   FQN="llvm::DILocation::getTemporary", NM="_ZN4llvm10DILocation12getTemporaryERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation12getTemporaryERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope) {
    return getTemporary(Context, Line, Column, Scope, (Metadata /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, Metadata /*P*/ Scope, Metadata /*P*/ InlinedAt/*= null*/) {
    return new std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/>(getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1207,
   FQN="llvm::DILocation::get", NM="_ZN4llvm10DILocation3getERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation3getERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_")
  //</editor-fold>
  public static DILocation /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope) {
    return get(Context, Line, Column, Scope, (DILocation /*P*/ )null);
  }
  public static DILocation /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope, DILocation /*P*/ InlinedAt/*= null*/) {
    return DILocation.getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1207,
   FQN="llvm::DILocation::getIfExists", NM="_ZN4llvm10DILocation11getIfExistsERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation11getIfExistsERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_")
  //</editor-fold>
  public static DILocation /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope) {
    return getIfExists(Context, Line, Column, Scope, (DILocation /*P*/ )null);
  }
  public static DILocation /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope, DILocation /*P*/ InlinedAt/*= null*/) {
    return DILocation.getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1207,
   FQN="llvm::DILocation::getDistinct", NM="_ZN4llvm10DILocation11getDistinctERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation11getDistinctERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_")
  //</editor-fold>
  public static DILocation /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope) {
    return getDistinct(Context, Line, Column, Scope, (DILocation /*P*/ )null);
  }
  public static DILocation /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope, DILocation /*P*/ InlinedAt/*= null*/) {
    return DILocation.getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1207,
   FQN="llvm::DILocation::getTemporary", NM="_ZN4llvm10DILocation12getTemporaryERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation12getTemporaryERNS_11LLVMContextEjjPNS_12DILocalScopeEPS0_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope) {
    return getTemporary(Context, Line, Column, Scope, (DILocation /*P*/ )null);
  }
  public static std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int Line, /*uint*/int Column, DILocalScope /*P*/ Scope, DILocation /*P*/ InlinedAt/*= null*/) {
    return new std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/>(DILocation.getImpl(Context, Line, Column, Scope, InlinedAt, StorageType.Temporary));
  }


  /// \brief Return a (temporary) clone of this.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1213,
   FQN="llvm::DILocation::clone", NM="_ZNK4llvm10DILocation5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DILocation /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1215,
   FQN="llvm::DILocation::getLine", NM="_ZNK4llvm10DILocation7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return SubclassData32;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1216,
   FQN="llvm::DILocation::getColumn", NM="_ZNK4llvm10DILocation9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ {
    return $ushort2uint(SubclassData16);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1217,
   FQN="llvm::DILocation::getScope", NM="_ZNK4llvm10DILocation8getScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation8getScopeEv")
  //</editor-fold>
  public DILocalScope /*P*/ getScope() /*const*/ {
    return cast_DILocalScope(getRawScope());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getInlinedAt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1218,
   FQN="llvm::DILocation::getInlinedAt", NM="_ZNK4llvm10DILocation12getInlinedAtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation12getInlinedAtEv")
  //</editor-fold>
  public DILocation /*P*/ getInlinedAt() /*const*/ {
    return cast_or_null_DILocation(getRawInlinedAt());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1222,
   FQN="llvm::DILocation::getFile", NM="_ZNK4llvm10DILocation7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation7getFileEv")
  //</editor-fold>
  public DIFile /*P*/ getFile() /*const*/ {
    return getScope().getFile();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getFilename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1223,
   FQN="llvm::DILocation::getFilename", NM="_ZNK4llvm10DILocation11getFilenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation11getFilenameEv")
  //</editor-fold>
  public StringRef getFilename() /*const*/ {
    return getScope().getFilename();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1224,
   FQN="llvm::DILocation::getDirectory", NM="_ZNK4llvm10DILocation12getDirectoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation12getDirectoryEv")
  //</editor-fold>
  public StringRef getDirectory() /*const*/ {
    return getScope().getDirectory();
  }


  /// \brief Get the scope where this is inlined.
  ///
  /// Walk through \a getInlinedAt() and return \a getScope() from the deepest
  /// location.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getInlinedAtScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1230,
   FQN="llvm::DILocation::getInlinedAtScope", NM="_ZNK4llvm10DILocation17getInlinedAtScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation17getInlinedAtScopeEv")
  //</editor-fold>
  public DILocalScope /*P*/ getInlinedAtScope() /*const*/ {
    {
      DILocation /*P*/ IA = getInlinedAt();
      if ((IA != null)) {
        return IA.getInlinedAtScope();
      }
    }
    return getScope();
  }


  /// \brief Check whether this can be discriminated from another location.
  ///
  /// Check \c this can be discriminated from \c RHS in a linetable entry.
  /// Scope and inlined-at chains are not recorded in the linetable, so they
  /// cannot be used to distinguish basic blocks.
  ///
  /// The current implementation is weaker than it should be, since it just
  /// checks filename and line.
  ///
  /// FIXME: Add a check for getDiscriminator().
  /// FIXME: Add a check for getColumn().
  /// FIXME: Change the getFilename() check to getFile() (or add one for
  /// getDirectory()).
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::canDiscriminate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1249,
   FQN="llvm::DILocation::canDiscriminate", NM="_ZNK4llvm10DILocation15canDiscriminateERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation15canDiscriminateERKS0_")
  //</editor-fold>
  public boolean canDiscriminate(final /*const*/ DILocation /*&*/ RHS) /*const*/ {
    return $noteq_StringRef(getFilename(), RHS.getFilename()) || getLine() != RHS.getLine();
  }


  /// \brief Get the DWARF discriminator.
  ///
  /// DWARF discriminators distinguish identical file locations between
  /// instructions that are on different basic blocks.
  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1593,
   FQN="llvm::DILocation::getDiscriminator", NM="_ZNK4llvm10DILocation16getDiscriminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation16getDiscriminatorEv")
  //</editor-fold>
  public /*uint*/int getDiscriminator() /*const*/ {
    {
      DILexicalBlockFile /*P*/ F = dyn_cast_DILexicalBlockFile(getScope());
      if ((F != null)) {
        return F.getDiscriminator();
      }
    }
    return 0;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getRawScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1259,
   FQN="llvm::DILocation::getRawScope", NM="_ZNK4llvm10DILocation11getRawScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation11getRawScopeEv")
  //</editor-fold>
  public Metadata /*P*/ getRawScope() /*const*/ {
    return getOperand(0).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::getRawInlinedAt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1260,
   FQN="llvm::DILocation::getRawInlinedAt", NM="_ZNK4llvm10DILocation15getRawInlinedAtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DILocation15getRawInlinedAtEv")
  //</editor-fold>
  public Metadata /*P*/ getRawInlinedAt() /*const*/ {
    if (getNumOperands() == 2) {
      return getOperand(1).$Metadata$P();
    }
    return null;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILocation::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1266,
   FQN="llvm::DILocation::classof", NM="_ZN4llvm10DILocation7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DILocation7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILocationKind.getValue();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
