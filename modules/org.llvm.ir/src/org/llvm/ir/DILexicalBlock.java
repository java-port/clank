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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1490,
 FQN="llvm::DILexicalBlock", NM="_ZN4llvm14DILexicalBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlockE")
//</editor-fold>
public class DILexicalBlock extends /*public*/ DILexicalBlockBase implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;
  private /*uint16_t*/char Column;

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::DILexicalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1497,
   FQN="llvm::DILexicalBlock::DILexicalBlock", NM="_ZN4llvm14DILexicalBlockC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlockC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DILexicalBlock(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int Line,
      /*uint*/int Column, ArrayRef<Metadata /*P*/ > Ops) {
    // : DILexicalBlockBase(C, DILexicalBlockKind, Storage, Ops), Line(Line), Column(Column)
    //START JInit
    super(C, MetadataKind.DILexicalBlockKind.getValue(), Storage, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    this.Column = $uint2ushort(Column);
    //END JInit
    assert ($less_uint(Column, (1/*U*/ << 16))) : "Expected 16-bit column";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::~DILexicalBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1503,
   FQN="llvm::DILexicalBlock::~DILexicalBlock", NM="_ZN4llvm14DILexicalBlockD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm14DILexicalBlockD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1505,
   FQN="llvm::DILexicalBlock::getImpl", NM="_ZN4llvm14DILexicalBlock7getImplERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjjNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock7getImplERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjjNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DILexicalBlock /*P*/ getImpl(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope,
         DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column,
         Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         File, Line, Column,
         Storage,
         true);
  }
  private static DILexicalBlock /*P*/ getImpl(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope,
         DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column,
         Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, ((/*static_cast*/Metadata /*P*/ )(Scope)),
        ((/*static_cast*/Metadata /*P*/ )(File)), Line, Column, Storage,
        ShouldCreate);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 444,
   FQN="llvm::DILexicalBlock::getImpl", NM="_ZN4llvm14DILexicalBlock7getImplERNS_11LLVMContextEPNS_8MetadataES4_jjNS3_11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock7getImplERNS_11LLVMContextEPNS_8MetadataES4_jjNS3_11StorageTypeEb")
  //</editor-fold>
  private static DILexicalBlock /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         Metadata /*P*/ File, /*uint*/int Line,
         /*uint*/int Column, Metadata.StorageType Storage) {
    return getImpl(Context, Scope,
         File, Line,
         Column, Storage,
         true);
  }
  private static DILexicalBlock /*P*/ getImpl(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope,
         Metadata /*P*/ File, /*uint*/int Line,
         /*uint*/int Column, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    // Fixup column.
    uint$ref Column$ref = create_uint$ref(Column);
    DebugInfoMetadataStatics.adjustColumn(Column$ref);
    Column = Column$ref.$deref();
    assert ((Scope != null)) : "Expected scope";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DILexicalBlock /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DILexicalBlocks, new MDNodeKeyImplDILexicalBlock(Scope, File, Line, Column));
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
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {File, Scope};
    int Column$final = Column;
    return MDNode.storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DILexicalBlock(Context, Storage, Line, Column$final, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DILexicalBlocks);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1518,
   FQN="llvm::DILexicalBlock::cloneImpl", NM="_ZNK4llvm14DILexicalBlock9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DILexicalBlock9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DILexicalBlock.getTemporary(getContext(), getScope(), getFile(), getLine(),
        getColumn());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1524,
   FQN="llvm::DILexicalBlock::get", NM="_ZN4llvm14DILexicalBlock3getERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock3getERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ get(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return DILexicalBlock.getImpl(Context, Scope, File, Line, Column, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1524,
   FQN="llvm::DILexicalBlock::getIfExists", NM="_ZN4llvm14DILexicalBlock11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock11getIfExistsERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ getIfExists(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return DILexicalBlock.getImpl(Context, Scope, File, Line, Column, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1524,
   FQN="llvm::DILexicalBlock::getDistinct", NM="_ZN4llvm14DILexicalBlock11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock11getDistinctERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ getDistinct(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return DILexicalBlock.getImpl(Context, Scope, File, Line, Column, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1524,
   FQN="llvm::DILexicalBlock::getTemporary", NM="_ZN4llvm14DILexicalBlock12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock12getTemporaryERNS_11LLVMContextEPNS_12DILocalScopeEPNS_6DIFileEjj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, DILocalScope /*P*/ Scope, DIFile /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return new std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/>(DILexicalBlock.getImpl(Context, Scope, File, Line, Column, StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1527,
   FQN="llvm::DILexicalBlock::get", NM="_ZN4llvm14DILexicalBlock3getERNS_11LLVMContextEPNS_8MetadataES4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock3getERNS_11LLVMContextEPNS_8MetadataES4_jj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ get(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return getImpl(Context, Scope, File, Line, Column, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1527,
   FQN="llvm::DILexicalBlock::getIfExists", NM="_ZN4llvm14DILexicalBlock11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock11getIfExistsERNS_11LLVMContextEPNS_8MetadataES4_jj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ getIfExists(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return getImpl(Context, Scope, File, Line, Column, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1527,
   FQN="llvm::DILexicalBlock::getDistinct", NM="_ZN4llvm14DILexicalBlock11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock11getDistinctERNS_11LLVMContextEPNS_8MetadataES4_jj")
  //</editor-fold>
  public static DILexicalBlock /*P*/ getDistinct(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return getImpl(Context, Scope, File, Line, Column, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1527,
   FQN="llvm::DILexicalBlock::getTemporary", NM="_ZN4llvm14DILexicalBlock12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock12getTemporaryERNS_11LLVMContextEPNS_8MetadataES4_jj")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, Metadata /*P*/ Scope, Metadata /*P*/ File, /*uint*/int Line, /*uint*/int Column) {
    return new std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/>(getImpl(Context, Scope, File, Line, Column, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1531,
   FQN="llvm::DILexicalBlock::clone", NM="_ZNK4llvm14DILexicalBlock5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DILexicalBlock5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DILexicalBlock /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1533,
   FQN="llvm::DILexicalBlock::getLine", NM="_ZNK4llvm14DILexicalBlock7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DILexicalBlock7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1534,
   FQN="llvm::DILexicalBlock::getColumn", NM="_ZNK4llvm14DILexicalBlock9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm14DILexicalBlock9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ {
    return $ushort2uint(Column);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DILexicalBlock::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 1536,
   FQN="llvm::DILexicalBlock::classof", NM="_ZN4llvm14DILexicalBlock7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm14DILexicalBlock7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DILexicalBlockKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + ", Column=" + $ushort2uint(Column) // NOI18N
              + super.toString(); // NOI18N
  }
}
