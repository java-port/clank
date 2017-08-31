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
import static org.clank.support.Unsigned.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.support.dwarf.Tag;


/// \brief Array subrange.
///
/// TODO: Merge into node for DW_TAG_array_type, which should have a custom
/// type.
//<editor-fold defaultstate="collapsed" desc="llvm::DISubrange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 310,
 FQN="llvm::DISubrange", NM="_ZN4llvm10DISubrangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrangeE")
//</editor-fold>
public class DISubrange extends /*public*/ DINode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private long/*int64_t*/ Count;
  private long/*int64_t*/ LowerBound;

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::DISubrange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 317,
   FQN="llvm::DISubrange::DISubrange", NM="_ZN4llvm10DISubrangeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrangeC1ERNS_11LLVMContextENS_8Metadata11StorageTypeExx")
  //</editor-fold>
  private DISubrange(final LLVMContext /*&*/ C, Metadata.StorageType Storage, long/*int64_t*/ Count,
      long/*int64_t*/ LowerBound) {
    // : DINode(C, DISubrangeKind, Storage, dwarf::DW_TAG_subrange_type, None), Count(Count), LowerBound(LowerBound)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DISubrangeKind.getValue(), Storage, $ushort2uint(Tag.DW_TAG_subrange_type), new ArrayRef<Metadata /*P*/ >(None, true));
    this.Count = Count;
    this.LowerBound = LowerBound;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::~DISubrange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 321,
   FQN="llvm::DISubrange::~DISubrange", NM="_ZN4llvm10DISubrangeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm10DISubrangeD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 215,
   FQN="llvm::DISubrange::getImpl", NM="_ZN4llvm10DISubrange7getImplERNS_11LLVMContextExxNS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange7getImplERNS_11LLVMContextExxNS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DISubrange /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ Lo,
         Metadata.StorageType Storage) {
    return getImpl(Context, Count, Lo,
         Storage, true);
  }
  private static DISubrange /*P*/ getImpl(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ Lo,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DISubrange /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DISubranges, new MDNodeKeyImplDISubrange(Count, Lo));
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
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (0U)*/ MDNode.$new(0/*U*/, (type$ptr<?> New$Mem)->{
            return new DISubrange(Context, Storage, Count, Lo);
         }), Storage, Context.pImpl.DISubranges);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 327,
   FQN="llvm::DISubrange::cloneImpl", NM="_ZNK4llvm10DISubrange9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DISubrange9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DISubrange /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DISubrange.getTemporary(getContext(), getCount(), getLowerBound());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 332,
   FQN="llvm::DISubrange::get", NM="_ZN4llvm10DISubrange3getERNS_11LLVMContextExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange3getERNS_11LLVMContextExx")
  //</editor-fold>
  public static DISubrange /*P*/ get(final LLVMContext /*&*/ Context, long/*int64_t*/ Count) {
    return get(Context, Count, 0);
  }
  public static DISubrange /*P*/ get(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ LowerBound/*= 0*/) {
    return getImpl(Context, Count, LowerBound, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 332,
   FQN="llvm::DISubrange::getIfExists", NM="_ZN4llvm10DISubrange11getIfExistsERNS_11LLVMContextExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange11getIfExistsERNS_11LLVMContextExx")
  //</editor-fold>
  public static DISubrange /*P*/ getIfExists(final LLVMContext /*&*/ Context, long/*int64_t*/ Count) {
    return getIfExists(Context, Count, 0);
  }
  public static DISubrange /*P*/ getIfExists(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ LowerBound/*= 0*/) {
    return getImpl(Context, Count, LowerBound, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 332,
   FQN="llvm::DISubrange::getDistinct", NM="_ZN4llvm10DISubrange11getDistinctERNS_11LLVMContextExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange11getDistinctERNS_11LLVMContextExx")
  //</editor-fold>
  public static DISubrange /*P*/ getDistinct(final LLVMContext /*&*/ Context, long/*int64_t*/ Count) {
    return getDistinct(Context, Count, 0);
  }
  public static DISubrange /*P*/ getDistinct(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ LowerBound/*= 0*/) {
    return getImpl(Context, Count, LowerBound, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 332,
   FQN="llvm::DISubrange::getTemporary", NM="_ZN4llvm10DISubrange12getTemporaryERNS_11LLVMContextExx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange12getTemporaryERNS_11LLVMContextExx")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DISubrange /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, long/*int64_t*/ Count) {
    return getTemporary(Context, Count, 0);
  }
  public static std.unique_ptr_with_deleter<DISubrange /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, long/*int64_t*/ Count, long/*int64_t*/ LowerBound/*= 0*/) {
    return new std.unique_ptr_with_deleter<DISubrange /*, TempMDNodeDeleter*/>(getImpl(Context, Count, LowerBound, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 335,
   FQN="llvm::DISubrange::clone", NM="_ZNK4llvm10DISubrange5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DISubrange5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DISubrange /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 337,
   FQN="llvm::DISubrange::getLowerBound", NM="_ZNK4llvm10DISubrange13getLowerBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DISubrange13getLowerBoundEv")
  //</editor-fold>
  public long/*int64_t*/ getLowerBound() /*const*/ {
    return LowerBound;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::getCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 338,
   FQN="llvm::DISubrange::getCount", NM="_ZNK4llvm10DISubrange8getCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm10DISubrange8getCountEv")
  //</editor-fold>
  public long/*int64_t*/ getCount() /*const*/ {
    return Count;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DISubrange::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 340,
   FQN="llvm::DISubrange::classof", NM="_ZN4llvm10DISubrange7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm10DISubrange7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DISubrangeKind.getValue();
  }


  @Override public String toString() {
    return "" + "Count=" + Count // NOI18N
              + ", LowerBound=" + LowerBound // NOI18N
              + super.toString(); // NOI18N
  }
}
