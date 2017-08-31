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
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2395,
 FQN="llvm::DIMacroFile", NM="_ZN4llvm11DIMacroFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFileE")
//</editor-fold>
public class DIMacroFile extends /*public*/ DIMacroNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::DIMacroFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2401,
   FQN="llvm::DIMacroFile::DIMacroFile", NM="_ZN4llvm11DIMacroFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFileC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIMacroFile(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int MIType,
      /*uint*/int Line, ArrayRef<Metadata /*P*/ > Ops) {
    // : DIMacroNode(C, DIMacroFileKind, Storage, MIType, Ops), Line(Line)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIMacroFileKind.getValue(), Storage, MIType, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::~DIMacroFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2404,
   FQN="llvm::DIMacroFile::~DIMacroFile", NM="_ZN4llvm11DIMacroFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11DIMacroFileD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2406,
   FQN="llvm::DIMacroFile::getImpl", NM="_ZN4llvm11DIMacroFile7getImplERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEENS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile7getImplERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEENS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIMacroFile /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, DIFile /*P*/ File,
         MDTupleTypedArrayWrapper<DIMacroNode> Elements, Metadata.StorageType Storage) {
    return getImpl(Context, MIType,
         Line, File,
         Elements, Storage,
         true);
  }
  private static DIMacroFile /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, DIFile /*P*/ File,
         MDTupleTypedArrayWrapper<DIMacroNode> Elements, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, MIType, Line, ((/*static_cast*/Metadata /*P*/ )(File)),
        Elements.get(), Storage, ShouldCreate);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 636,
   FQN="llvm::DIMacroFile::getImpl", NM="_ZN4llvm11DIMacroFile7getImplERNS_11LLVMContextEjjPNS_8MetadataES4_NS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile7getImplERNS_11LLVMContextEjjPNS_8MetadataES4_NS3_11StorageTypeEb")
  //</editor-fold>
  private static DIMacroFile /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, Metadata /*P*/ File,
         Metadata /*P*/ Elements, Metadata.StorageType Storage) {
    return getImpl(Context, MIType,
         Line, File,
         Elements, Storage,
         true);
  }
  private static DIMacroFile /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, Metadata /*P*/ File,
         Metadata /*P*/ Elements, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIMacroFile /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIMacroFiles, new MDNodeKeyImplDIMacroFile(MIType, Line, File, Elements));
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
    } while (false);
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {File, Elements};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIMacroFile(Context, Storage, MIType, Line, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIMacroFiles);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2418,
   FQN="llvm::DIMacroFile::cloneImpl", NM="_ZNK4llvm11DIMacroFile9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIMacroFile.getTemporary(getContext(), getMacinfoType(), getLine(), getFile(),
        getElements());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2424,
   FQN="llvm::DIMacroFile::get", NM="_ZN4llvm11DIMacroFile3getERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile3getERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public static DIMacroFile /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, DIFile /*P*/ File, MDTupleTypedArrayWrapper<DIMacroNode> Elements) {
    return DIMacroFile.getImpl(Context, MIType, Line, File, new MDTupleTypedArrayWrapper<DIMacroNode>(Elements), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2424,
   FQN="llvm::DIMacroFile::getIfExists", NM="_ZN4llvm11DIMacroFile11getIfExistsERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile11getIfExistsERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public static DIMacroFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, DIFile /*P*/ File, MDTupleTypedArrayWrapper<DIMacroNode> Elements) {
    return DIMacroFile.getImpl(Context, MIType, Line, File, new MDTupleTypedArrayWrapper<DIMacroNode>(Elements), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2424,
   FQN="llvm::DIMacroFile::getDistinct", NM="_ZN4llvm11DIMacroFile11getDistinctERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile11getDistinctERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public static DIMacroFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, DIFile /*P*/ File, MDTupleTypedArrayWrapper<DIMacroNode> Elements) {
    return DIMacroFile.getImpl(Context, MIType, Line, File, new MDTupleTypedArrayWrapper<DIMacroNode>(Elements), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2424,
   FQN="llvm::DIMacroFile::getTemporary", NM="_ZN4llvm11DIMacroFile12getTemporaryERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile12getTemporaryERNS_11LLVMContextEjjPNS_6DIFileENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, DIFile /*P*/ File, MDTupleTypedArrayWrapper<DIMacroNode> Elements) {
    return new std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/>(DIMacroFile.getImpl(Context, MIType, Line, File, new MDTupleTypedArrayWrapper<DIMacroNode>(Elements), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2427,
   FQN="llvm::DIMacroFile::get", NM="_ZN4llvm11DIMacroFile3getERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile3getERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DIMacroFile /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, Metadata /*P*/ File, Metadata /*P*/ Elements) {
    return getImpl(Context, MIType, Line, File, Elements, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2427,
   FQN="llvm::DIMacroFile::getIfExists", NM="_ZN4llvm11DIMacroFile11getIfExistsERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile11getIfExistsERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DIMacroFile /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, Metadata /*P*/ File, Metadata /*P*/ Elements) {
    return getImpl(Context, MIType, Line, File, Elements, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2427,
   FQN="llvm::DIMacroFile::getDistinct", NM="_ZN4llvm11DIMacroFile11getDistinctERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile11getDistinctERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static DIMacroFile /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, Metadata /*P*/ File, Metadata /*P*/ Elements) {
    return getImpl(Context, MIType, Line, File, Elements, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2427,
   FQN="llvm::DIMacroFile::getTemporary", NM="_ZN4llvm11DIMacroFile12getTemporaryERNS_11LLVMContextEjjPNS_8MetadataES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile12getTemporaryERNS_11LLVMContextEjjPNS_8MetadataES4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, Metadata /*P*/ File, Metadata /*P*/ Elements) {
    return new std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/>(getImpl(Context, MIType, Line, File, Elements, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2431,
   FQN="llvm::DIMacroFile::clone", NM="_ZNK4llvm11DIMacroFile5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIMacroFile /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::replaceElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2433,
   FQN="llvm::DIMacroFile::replaceElements", NM="_ZN4llvm11DIMacroFile15replaceElementsENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile15replaceElementsENS_24MDTupleTypedArrayWrapperINS_11DIMacroNodeEEE")
  //</editor-fold>
  public void replaceElements(MDTupleTypedArrayWrapper<DIMacroNode> Elements) {
    for (DIMacroNode /*P*/ Op : getElements())  {
      assert ((std.find(Elements.$arrow().op_begin(), Elements.$arrow().op_end(), Op) != null)) : "Lost a macro node during macro node list replacement";
    }
    replaceOperandWith(1, Elements.get());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2442,
   FQN="llvm::DIMacroFile::getLine", NM="_ZNK4llvm11DIMacroFile7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2443,
   FQN="llvm::DIMacroFile::getFile", NM="_ZNK4llvm11DIMacroFile7getFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile7getFileEv")
  //</editor-fold>
  public DIFile /*P*/ getFile() /*const*/ {
    return cast_or_null_DIFile(getRawFile());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getElements">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2445,
   FQN="llvm::DIMacroFile::getElements", NM="_ZNK4llvm11DIMacroFile11getElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile11getElementsEv")
  //</editor-fold>
  public MDTupleTypedArrayWrapper<DIMacroNode> getElements() /*const*/ {
    return new MDTupleTypedArrayWrapper<DIMacroNode>(DIMacroNode.class, cast_or_null_MDTuple(getRawElements()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getRawFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2449,
   FQN="llvm::DIMacroFile::getRawFile", NM="_ZNK4llvm11DIMacroFile10getRawFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile10getRawFileEv")
  //</editor-fold>
  public Metadata /*P*/ getRawFile() /*const*/ {
    return getOperand(0).$Metadata$P();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::getRawElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2450,
   FQN="llvm::DIMacroFile::getRawElements", NM="_ZNK4llvm11DIMacroFile14getRawElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm11DIMacroFile14getRawElementsEv")
  //</editor-fold>
  public Metadata /*P*/ getRawElements() /*const*/ {
    return getOperand(1).$Metadata$P();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacroFile::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2452,
   FQN="llvm::DIMacroFile::classof", NM="_ZN4llvm11DIMacroFile7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm11DIMacroFile7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIMacroFileKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
