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
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DIMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2346,
 FQN="llvm::DIMacro", NM="_ZN4llvm7DIMacroE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacroE")
//</editor-fold>
public class DIMacro extends /*public*/ DIMacroNode implements Destructors.ClassWithDestructor {
  /*friend  class LLVMContextImpl*/
  /*friend  class MDNode*/

  private /*uint*/int Line;

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::DIMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2352,
   FQN="llvm::DIMacro::DIMacro", NM="_ZN4llvm7DIMacroC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacroC1ERNS_11LLVMContextENS_8Metadata11StorageTypeEjjNS_8ArrayRefIPS3_EE")
  //</editor-fold>
  private DIMacro(final LLVMContext /*&*/ C, Metadata.StorageType Storage, /*uint*/int MIType, /*uint*/int Line,
      ArrayRef<Metadata /*P*/ > Ops) {
    // : DIMacroNode(C, DIMacroKind, Storage, MIType, Ops), Line(Line)
    //START JInit
    /*ExprWithCleanups*/super(C, MetadataKind.DIMacroKind.getValue(), Storage, MIType, new ArrayRef<Metadata /*P*/ >(Ops));
    this.Line = Line;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::~DIMacro">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2355,
   FQN="llvm::DIMacro::~DIMacro", NM="_ZN4llvm7DIMacroD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm7DIMacroD0Ev")
  //</editor-fold>
  public/*private*/ void $destroy()/* = default*/ {
    super.$destroy();
  }



  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2357,
   FQN="llvm::DIMacro::getImpl", NM="_ZN4llvm7DIMacro7getImplERNS_11LLVMContextEjjNS_9StringRefES3_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro7getImplERNS_11LLVMContextEjjNS_9StringRefES3_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIMacro /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line,
         StringRef Name, StringRef Value, Metadata.StorageType Storage) {
    return getImpl(Context, MIType, Line,
         Name, Value, Storage,
         true);
  }
  private static DIMacro /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line,
         StringRef Name, StringRef Value, Metadata.StorageType Storage,
         boolean ShouldCreate/*= true*/) {
    return getImpl(Context, MIType, Line, DIMacroNode.getCanonicalMDString(Context, new StringRef(Name)),
        DIMacroNode.getCanonicalMDString(Context, new StringRef(Value)), Storage, ShouldCreate);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp", line = 627,
   FQN="llvm::DIMacro::getImpl", NM="_ZN4llvm7DIMacro7getImplERNS_11LLVMContextEjjPNS_8MDStringES4_NS_8Metadata11StorageTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro7getImplERNS_11LLVMContextEjjPNS_8MDStringES4_NS_8Metadata11StorageTypeEb")
  //</editor-fold>
  private static DIMacro /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value,
         Metadata.StorageType Storage) {
    return getImpl(Context, MIType,
         Line, Name, Value,
         Storage, true);
  }
  private static DIMacro /*P*/ getImpl(final LLVMContext /*&*/ Context, /*uint*/int MIType,
         /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value,
         Metadata.StorageType Storage, boolean ShouldCreate/*= true*/) {
    assert (DebugInfoMetadataStatics.isCanonical(Name)) : "Expected canonical MDString";
    do {
      if (Storage == StorageType.Uniqued) {
        {
          DIMacro /*P*/ N = IrLlvmStatics.getUniqued(Context.pImpl.DIMacros, new MDNodeKeyImplDIMacro(MIType, Line, Name, Value));
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
    Metadata /*P*/ Ops[/*2*/] = new Metadata /*P*/  [/*2*/] {Name, Value};
    return storeImpl(/*NEW_EXPR [MDNode::new]*//*new (array_lengthof(Ops))*/ MDNode.$new(array_lengthof(Ops), (type$ptr<?> New$Mem)->{
            return new DIMacro(Context, Storage, MIType, Line, new ArrayRef<Metadata /*P*/ >(Ops, true));
         }), Storage, Context.pImpl.DIMacros);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::cloneImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2367,
   FQN="llvm::DIMacro::cloneImpl", NM="_ZNK4llvm7DIMacro9cloneImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro9cloneImplEv")
  //</editor-fold>
  /*friend*//*private*/ std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/> cloneImpl() /*const*/ {
    return DIMacro.getTemporary(getContext(), getMacinfoType(), getLine(), getName(),
        getValue());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2373,
   FQN="llvm::DIMacro::get", NM="_ZN4llvm7DIMacro3getERNS_11LLVMContextEjjNS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro3getERNS_11LLVMContextEjjNS_9StringRefES3_")
  //</editor-fold>
  public static DIMacro /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name) {
    return get(Context, MIType, Line, Name, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIMacro /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name, StringRef Value/*= ""*/) {
    return DIMacro.getImpl(Context, MIType, Line, new StringRef(Name), new StringRef(Value), StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2373,
   FQN="llvm::DIMacro::getIfExists", NM="_ZN4llvm7DIMacro11getIfExistsERNS_11LLVMContextEjjNS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro11getIfExistsERNS_11LLVMContextEjjNS_9StringRefES3_")
  //</editor-fold>
  public static DIMacro /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name) {
    return getIfExists(Context, MIType, Line, Name, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIMacro /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name, StringRef Value/*= ""*/) {
    return DIMacro.getImpl(Context, MIType, Line, new StringRef(Name), new StringRef(Value), StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2373,
   FQN="llvm::DIMacro::getDistinct", NM="_ZN4llvm7DIMacro11getDistinctERNS_11LLVMContextEjjNS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro11getDistinctERNS_11LLVMContextEjjNS_9StringRefES3_")
  //</editor-fold>
  public static DIMacro /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name) {
    return getDistinct(Context, MIType, Line, Name, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static DIMacro /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name, StringRef Value/*= ""*/) {
    return DIMacro.getImpl(Context, MIType, Line, new StringRef(Name), new StringRef(Value), StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2373,
   FQN="llvm::DIMacro::getTemporary", NM="_ZN4llvm7DIMacro12getTemporaryERNS_11LLVMContextEjjNS_9StringRefES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro12getTemporaryERNS_11LLVMContextEjjNS_9StringRefES3_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name) {
    return getTemporary(Context, MIType, Line, Name, new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public static std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, StringRef Name, StringRef Value/*= ""*/) {
    return new std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/>(DIMacro.getImpl(Context, MIType, Line, new StringRef(Name), new StringRef(Value), StorageType.Temporary));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2376,
   FQN="llvm::DIMacro::get", NM="_ZN4llvm7DIMacro3getERNS_11LLVMContextEjjPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro3getERNS_11LLVMContextEjjPNS_8MDStringES4_")
  //</editor-fold>
  public static DIMacro /*P*/ get(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value) {
    return getImpl(Context, MIType, Line, Name, Value, StorageType.Uniqued);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2376,
   FQN="llvm::DIMacro::getIfExists", NM="_ZN4llvm7DIMacro11getIfExistsERNS_11LLVMContextEjjPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro11getIfExistsERNS_11LLVMContextEjjPNS_8MDStringES4_")
  //</editor-fold>
  public static DIMacro /*P*/ getIfExists(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value) {
    return getImpl(Context, MIType, Line, Name, Value, StorageType.Uniqued, false);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2376,
   FQN="llvm::DIMacro::getDistinct", NM="_ZN4llvm7DIMacro11getDistinctERNS_11LLVMContextEjjPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro11getDistinctERNS_11LLVMContextEjjPNS_8MDStringES4_")
  //</editor-fold>
  public static DIMacro /*P*/ getDistinct(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value) {
    return getImpl(Context, MIType, Line, Name, Value, StorageType.Distinct);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2376,
   FQN="llvm::DIMacro::getTemporary", NM="_ZN4llvm7DIMacro12getTemporaryERNS_11LLVMContextEjjPNS_8MDStringES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro12getTemporaryERNS_11LLVMContextEjjPNS_8MDStringES4_")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context, /*uint*/int MIType, /*uint*/int Line, MDString /*P*/ Name, MDString /*P*/ Value) {
    return new std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/>(getImpl(Context, MIType, Line, Name, Value, StorageType.Temporary));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2380,
   FQN="llvm::DIMacro::clone", NM="_ZNK4llvm7DIMacro5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<DIMacro /*, TempMDNodeDeleter*/> clone() /*const*/ {
    return cloneImpl();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2382,
   FQN="llvm::DIMacro::getLine", NM="_ZNK4llvm7DIMacro7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2384,
   FQN="llvm::DIMacro::getName", NM="_ZNK4llvm7DIMacro7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return getStringOperand(0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2385,
   FQN="llvm::DIMacro::getValue", NM="_ZNK4llvm7DIMacro8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro8getValueEv")
  //</editor-fold>
  public StringRef getValue() /*const*/ {
    return getStringOperand(1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getRawName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2387,
   FQN="llvm::DIMacro::getRawName", NM="_ZNK4llvm7DIMacro10getRawNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro10getRawNameEv")
  //</editor-fold>
  public MDString /*P*/ getRawName() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::getRawValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2388,
   FQN="llvm::DIMacro::getRawValue", NM="_ZNK4llvm7DIMacro11getRawValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZNK4llvm7DIMacro11getRawValueEv")
  //</editor-fold>
  public MDString /*P*/ getRawValue() /*const*/ {
    return this.<MDString>getOperandAs(MDString.class, 1);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DIMacro::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfoMetadata.h", line = 2390,
   FQN="llvm::DIMacro::classof", NM="_ZN4llvm7DIMacro7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=_ZN4llvm7DIMacro7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    return MD.getMetadataID() == MetadataKind.DIMacroKind.getValue();
  }


  @Override public String toString() {
    return "" + "Line=" + Line // NOI18N
              + super.toString(); // NOI18N
  }
}
