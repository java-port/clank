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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.java.*;
import static org.llvm.support.AdtsupportLlvmGlobals.*;
import static org.llvm.ir.TypeBasedAliasAnalysisStatics.*;
import org.llvm.ir.mdconst.MdconstGlobals;


/// \brief Metadata node.
///
/// Metadata nodes can be uniqued, like constants, or distinct.  Temporary
/// metadata nodes (with full support for RAUW) can be used to delay uniquing
/// until forward references are known.  The basic metadata node is an \a
/// MDTuple.
///
/// There is limited support for RAUW at construction time.  At construction
/// time, if any operand is a temporary node (or an unresolved uniqued node,
/// which indicates a transitive temporary operand), the node itself will be
/// unresolved.  As soon as all operands become resolved, it will drop RAUW
/// support permanently.
///
/// If an unresolved node is part of a cycle, \a resolveCycles() needs
/// to be called on some member of the cycle once all temporary nodes have been
/// replaced.
//<editor-fold defaultstate="collapsed" desc="llvm::MDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 808,
 FQN="llvm::MDNode", NM="_ZN4llvm6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodeE")
//</editor-fold>
public class MDNode extends /*public*/ Metadata implements Destructors.ClassWithDestructor {
  /*friend  class ReplaceableMetadataImpl*/
  /*friend  class LLVMContextImpl*/

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::MDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 812,
   FQN="llvm::MDNode::MDNode", NM="_ZN4llvm6MDNodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MDNode(final /*const*/ MDNode /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 813,
   FQN="llvm::MDNode::operator=", NM="_ZN4llvm6MDNodeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodeaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MDNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 814,
   FQN="llvm::MDNode::operator new", NM="_ZN4llvm6MDNodenwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodenwEj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new(/*size_t*/int $Prm0) { throw new UnsupportedOperationException("Deleted");}


  private /*uint*/int NumOperands;
  private /*uint*/int NumUnresolved;

  /*friend*//*package*//*private*/ ContextAndReplaceableUses Context;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 444,
   FQN="llvm::MDNode::operator new", NM="_ZN4llvm6MDNodenwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodenwEjj")
  //</editor-fold>
  protected static <T extends MDNode>/*void P*/ T $new(/*size_t*/int UnusedSizeof, /*uint*/int NumOps, New$ConstructorCallback<T> $Ctor) {
    Object[] data = new Object[1 + NumOps];
    type$ptr<?>/*void P*/ Start = create_type$ptr(data);
    type$ptr<?>/*void P*/ Result = Start.$add(NumOps);
    for (int i = 0; i < data.length - 1; i++) {
      data[i] = new MDOperand();
    }
    return callConstructorImpl(Result, $Ctor);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator delete">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 456,
   FQN="llvm::MDNode::operator delete", NM="_ZN4llvm6MDNodedlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodedlEPv")
  //</editor-fold>
  protected static void $delete(MDNode/*void P*/ Mem) {
    MDNode /*P*/ N = ((/*static_cast*/MDNode /*P*/ )(Mem));
    type$ptr<MDOperand> /*P*/ O = ((/*static_cast*/type$ptr<MDOperand> /*P*/ )(N.$This$Ptr()));
    for (type$ptr<MDOperand> /*P*/ E = O.$sub(N.NumOperands); O.$noteq(E); O.$preDec())  {
      O.$sub(1).$arrow().$destroy();
    }
    ///*::*/$delete_voidPtr(reinterpret_cast(char$ptr/*char P*/ .class, Mem).$sub(OpSize));
  }


  /// \brief Required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 826,
   FQN="llvm::MDNode::operator delete", NM="_ZN4llvm6MDNodedlEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodedlEPvj")
  //</editor-fold>
  protected static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1) {
    throw new llvm_unreachable("Constructor throws?");
  }


  /// \brief Required by std, but never called.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 831,
   FQN="llvm::MDNode::operator delete", NM="_ZN4llvm6MDNodedlEPvjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodedlEPvjb")
  //</editor-fold>
  protected static void $delete(Object/*void P*/ $Prm0, /*uint*/int $Prm1, boolean $Prm2) {
    throw new llvm_unreachable("Constructor throws?");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::MDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 467,
   FQN="llvm::MDNode::MDNode", NM="_ZN4llvm6MDNodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodeC1ERNS_11LLVMContextEjNS_8Metadata11StorageTypeENS_8ArrayRefIPS3_EES7_")
  //</editor-fold>
  protected MDNode(final LLVMContext /*&*/ Context, /*uint*/int ID, Metadata.StorageType Storage,
      ArrayRef<Metadata /*P*/ > Ops1) {
    this(Context, ID, Storage,
      Ops1, new ArrayRef<Metadata /*P*/ >(None, true));
  }
  protected MDNode(final LLVMContext /*&*/ Context, /*uint*/int ID, Metadata.StorageType Storage,
      ArrayRef<Metadata /*P*/ > Ops1, ArrayRef<Metadata /*P*/ > Ops2/*= None*/) {
    // : Metadata(ID, Storage), NumOperands(Ops1.size() + Ops2.size()), NumUnresolved(0), Context(Context)
    //START JInit
    super(ID, Storage);
    this.NumOperands = Ops1.size() + Ops2.size();
    this.NumUnresolved = 0;
    this.Context = new ContextAndReplaceableUses(Context);
    //END JInit
    /*uint*/int Op = 0;
    for (Metadata /*P*/ MD : Ops1)  {
      setOperand(Op++, MD);
    }
    for (Metadata /*P*/ MD : Ops2)  {
      setOperand(Op++, MD);
    }
    if (!isUniqued()) {
      return;
    }

    // Count the unresolved operands.  If there are any, RAUW support will be
    // added lazily on first reference.
    countUnresolvedOperands();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::~MDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 837,
   FQN="llvm::MDNode::~MDNode", NM="_ZN4llvm6MDNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNodeD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    //START JDestroy
    Context.$destroy();
    super.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 653,
   FQN="llvm::MDNode::dropAllReferences", NM="_ZN4llvm6MDNode17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode17dropAllReferencesEv")
  //</editor-fold>
  /*friend*/public/*protected*/ void dropAllReferences() {
    for (/*uint*/int I = 0, E = NumOperands; I != E; ++I)  {
      setOperand(I, (Metadata /*P*/ )null);
    }
    if (Context.hasReplaceableUses()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Context.getReplaceableUses().resolveAllUses(/* ResolveUsers */ false);
        /*J:(void)*/$c$.track(Context.takeReplaceableUses()); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::mutable_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 841,
   FQN="llvm::MDNode::mutable_begin", NM="_ZN4llvm6MDNode13mutable_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode13mutable_beginEv")
  //</editor-fold>
  protected type$ptr<MDOperand> /*P*/ mutable_begin() {
    return mutable_end().$sub(NumOperands);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::mutable_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 842,
   FQN="llvm::MDNode::mutable_end", NM="_ZN4llvm6MDNode11mutable_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode11mutable_endEv")
  //</editor-fold>
  protected type$ptr<MDOperand> /*P*/ mutable_end() {
    return (type$ptr<MDOperand>) this.$This$Ptr();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::mutable_operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 845,
   FQN="llvm::MDNode::mutable_operands", NM="_ZN4llvm6MDNode16mutable_operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode16mutable_operandsEv")
  //</editor-fold>
  protected iterator_range<MDOperand> mutable_operands() {
    return new iterator_range<MDOperand>(mutable_begin(), mutable_end());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1106,
   FQN="llvm::MDNode::get", NM="_ZN4llvm6MDNode3getERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode3getERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ get(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return MDTuple.get(Context, new ArrayRef<Metadata /*P*/ >(MDs));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getIfExists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1109,
   FQN="llvm::MDNode::getIfExists", NM="_ZN4llvm6MDNode11getIfExistsERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode11getIfExistsERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ getIfExists(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return MDTuple.getIfExists(Context, new ArrayRef<Metadata /*P*/ >(MDs));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1112,
   FQN="llvm::MDNode::getDistinct", NM="_ZN4llvm6MDNode11getDistinctERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode11getDistinctERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static MDTuple /*P*/ getDistinct(final LLVMContext /*&*/ Context, ArrayRef<Metadata /*P*/ > MDs) {
    return MDTuple.getDistinct(Context, new ArrayRef<Metadata /*P*/ >(MDs));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1115,
   FQN="llvm::MDNode::getTemporary", NM="_ZN4llvm6MDNode12getTemporaryERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode12getTemporaryERNS_11LLVMContextENS_8ArrayRefIPNS_8MetadataEEE")
  //</editor-fold>
  public static std.unique_ptr_with_deleter<MDTuple /*, TempMDNodeDeleter*/> getTemporary(final LLVMContext /*&*/ Context,
              ArrayRef<Metadata /*P*/ > MDs) {
    return MDTuple.getTemporary(Context, new ArrayRef<Metadata /*P*/ >(MDs));
  }


  /// \brief Create a (temporary) clone of this.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::clone">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 485,
   FQN="llvm::MDNode::clone", NM="_ZNK4llvm6MDNode5cloneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode5cloneEv")
  //</editor-fold>
  public std.unique_ptr_with_deleter<? extends MDNode /*, TempMDNodeDeleter*/> clone() /*const*/ {
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid MDNode subclass");
     case MDTupleKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_MDTuple(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DILocationKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DILocation(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIExpressionKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIExpression(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case GenericDINodeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_GenericDINode(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DISubrangeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DISubrange(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIEnumeratorKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIEnumerator(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIBasicTypeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIBasicType(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIDerivedTypeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIDerivedType(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DICompositeTypeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DICompositeType(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DISubroutineTypeKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DISubroutineType(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIFileKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIFile(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DICompileUnitKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DICompileUnit(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DISubprogramKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DISubprogram(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DILexicalBlockKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DILexicalBlock(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DILexicalBlockFileKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DILexicalBlockFile(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DINamespaceKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DINamespace(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIModuleKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIModule(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DITemplateTypeParameterKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DITemplateTypeParameter(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DITemplateValueParameterKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DITemplateValueParameter(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIGlobalVariableKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIGlobalVariable(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DILocalVariableKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DILocalVariable(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIObjCPropertyKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIObjCProperty(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIImportedEntityKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIImportedEntity(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIMacroKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIMacro(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
     case DIMacroFileKind:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new std.unique_ptr_with_deleter<MDNode /*, TempMDNodeDeleter*/>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(cast_DIMacroFile(this).cloneImpl())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }


  /// \brief Deallocate a node created by getTemporary.
  ///
  /// Calls \c replaceAllUsesWith(nullptr) before deleting, so any remaining
  /// references will be reset.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::deleteTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 794,
   FQN="llvm::MDNode::deleteTemporary", NM="_ZN4llvm6MDNode15deleteTemporaryEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode15deleteTemporaryEPS0_")
  //</editor-fold>
  public static void deleteTemporary(MDNode /*P*/ N) {
    assert (N.isTemporary()) : "Expected temporary node";
    N.replaceAllUsesWith((Metadata /*P*/ )null);
    N.deleteAsSubclass();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 867,
   FQN="llvm::MDNode::getContext", NM="_ZNK4llvm6MDNode10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode10getContextEv")
  //</editor-fold>
  public LLVMContext /*&*/ getContext() /*const*/ {
    return Context.getContext();
  }


  /// \brief Replace a specific operand.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceOperandWith">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 822,
   FQN="llvm::MDNode::replaceOperandWith", NM="_ZN4llvm6MDNode18replaceOperandWithEjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode18replaceOperandWithEjPNS_8MetadataE")
  //</editor-fold>
  public void replaceOperandWith(/*uint*/int I, Metadata /*P*/ New) {
    if (getOperand(I).$Metadata$P() == New) {
      return;
    }
    if (!isUniqued()) {
      setOperand(I, New);
      return;
    }

    handleChangedOperand(mutable_begin().$add(I), New);
  }


  /// \brief Check if node is fully resolved.
  ///
  /// If \a isTemporary(), this always returns \c false; if \a isDistinct(),
  /// this always returns \c true.
  ///
  /// If \a isUniqued(), returns \c true if this has already dropped RAUW
  /// support (because all operands are resolved).
  ///
  /// As forward declarations are resolved, their containers should get
  /// resolved automatically.  However, if this (or one of its operands) is
  /// involved in a cycle, \a resolveCycles() needs to be called explicitly.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::isResolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 883,
   FQN="llvm::MDNode::isResolved", NM="_ZNK4llvm6MDNode10isResolvedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode10isResolvedEv")
  //</editor-fold>
  public boolean isResolved() /*const*/ {
    return !isTemporary() && !(NumUnresolved != 0);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::isUniqued">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 885,
   FQN="llvm::MDNode::isUniqued", NM="_ZNK4llvm6MDNode9isUniquedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode9isUniquedEv")
  //</editor-fold>
  public boolean isUniqued() /*const*/ {
    return $uchar2int(Storage) == StorageType.Uniqued.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::isDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 886,
   FQN="llvm::MDNode::isDistinct", NM="_ZNK4llvm6MDNode10isDistinctEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode10isDistinctEv")
  //</editor-fold>
  public boolean isDistinct() /*const*/ {
    return $uchar2int(Storage) == StorageType.Distinct.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::isTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 887,
   FQN="llvm::MDNode::isTemporary", NM="_ZNK4llvm6MDNode11isTemporaryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode11isTemporaryEv")
  //</editor-fold>
  public boolean isTemporary() /*const*/ {
    return $uchar2int(Storage) == StorageType.Temporary.getValue();
  }


  /// \brief RAUW a temporary.
  ///
  /// \pre \a isTemporary() must be \c true.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceAllUsesWith">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 892,
   FQN="llvm::MDNode::replaceAllUsesWith", NM="_ZN4llvm6MDNode18replaceAllUsesWithEPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode18replaceAllUsesWithEPNS_8MetadataE")
  //</editor-fold>
  public void replaceAllUsesWith(Metadata /*P*/ MD) {
    assert (isTemporary()) : "Expected temporary node";
    if (Context.hasReplaceableUses()) {
      Context.getReplaceableUses().replaceAllUsesWith(MD);
    }
  }


  /// \brief Resolve cycles.
  ///
  /// Once all forward declarations have been resolved, force cycles to be
  /// resolved.
  ///
  /// \pre No operands (or operands' operands, etc.) have \a isTemporary().
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::resolveCycles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 584,
   FQN="llvm::MDNode::resolveCycles", NM="_ZN4llvm6MDNode13resolveCyclesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode13resolveCyclesEv")
  //</editor-fold>
  public void resolveCycles() {
    if (isResolved()) {
      return;
    }

    // Resolve this node immediately.
    resolve();

    // Resolve all operands.
    for (final /*const*/ MDOperand /*&*/ Op : operands()) {
      MDNode /*P*/ N = dyn_cast_or_null_MDNode(Op);
      if (!(N != null)) {
        continue;
      }
      assert (!N.isTemporary()) : "Expected all forward declarations to be resolved";
      if (!N.isResolved()) {
        N.resolveCycles();
      }
    }
  }


  /// \brief Replace a temporary node with a permanent one.
  ///
  /// Try to create a uniqued version of \c N -- in place, if possible -- and
  /// return it.  If \c N cannot be uniqued, return a distinct node instead.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithPermanent">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 911,
   FQN="llvm::MDNode::replaceWithPermanent", NM="Tpl__ZN4llvm6MDNode20replaceWithPermanentESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode20replaceWithPermanentESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE")
  //</editor-fold>
  public static </*class*/ T extends MDNode> /*std::enable_if<std::is_base_of<MDNode, T>::value, T  >::type*/T /*P*/ replaceWithPermanent$BaseOfMDNode(std.unique_ptr_with_deleter<T /*, TempMDNodeDeleter*/> N) {
    N.release().replaceWithPermanentImpl();
    return (T)(N.release().replaceWithPermanentImpl());
  }


  /// \brief Replace a temporary node with a uniqued one.
  ///
  /// Create a uniqued version of \c N -- in place, if possible -- and return
  /// it.  Takes ownership of the temporary node.
  ///
  /// \pre N does not self-reference.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithUniqued">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 923,
   FQN="llvm::MDNode::replaceWithUniqued", NM="Tpl__ZN4llvm6MDNode18replaceWithUniquedESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode18replaceWithUniquedESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE")
  //</editor-fold>
  public static </*class*/ T extends MDNode> /*std::enable_if<std::is_base_of<MDNode, T>::value, T  >::type*/T /*P*/ replaceWithUniqued$BaseOfMDNode(std.unique_ptr_with_deleter<T /*, TempMDNodeDeleter*/> N) {
    return (T)(N.release().replaceWithUniquedImpl());
  }


  /// \brief Replace a temporary node with a distinct one.
  ///
  /// Create a distinct version of \c N -- in place, if possible -- and return
  /// it.  Takes ownership of the temporary node.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithDistinct">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 933,
   FQN="llvm::MDNode::replaceWithDistinct", NM="Tpl__ZN4llvm6MDNode19replaceWithDistinctESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode19replaceWithDistinctESt10unique_ptrIT_NS_17TempMDNodeDeleterEER_ZTSNSt9enable_ifIXsr3std10is_base_ofIN4llvm6MDNodeET_EE5valueEPS2_E4typeE")
  //</editor-fold>
  public static </*class*/ T extends MDNode> /*std::enable_if<std::is_base_of<MDNode, T>::value, T  >::type*/T /*P*/ replaceWithDistinct$BaseOfMDNode(std.unique_ptr_with_deleter<T /*, TempMDNodeDeleter*/> N) {
    return (T)(N.release().replaceWithDistinctImpl());
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithPermanentImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 611,
   FQN="llvm::MDNode::replaceWithPermanentImpl", NM="_ZN4llvm6MDNode24replaceWithPermanentImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode24replaceWithPermanentImplEv")
  //</editor-fold>
  /*private*//*friend*//*package*/ MDNode /*P*/ replaceWithPermanentImpl() {
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      // If this type isn't uniquable, replace with a distinct node.
      return replaceWithDistinctImpl();
     case MDTupleKind:
      break;
     case DILocationKind:
      break;
     case DIExpressionKind:
      break;
     case GenericDINodeKind:
      break;
     case DISubrangeKind:
      break;
     case DIEnumeratorKind:
      break;
     case DIBasicTypeKind:
      break;
     case DIDerivedTypeKind:
      break;
     case DICompositeTypeKind:
      break;
     case DISubroutineTypeKind:
      break;
     case DIFileKind:
      break;
     case DISubprogramKind:
      break;
     case DILexicalBlockKind:
      break;
     case DILexicalBlockFileKind:
      break;
     case DINamespaceKind:
      break;
     case DIModuleKind:
      break;
     case DITemplateTypeParameterKind:
      break;
     case DITemplateValueParameterKind:
      break;
     case DIGlobalVariableKind:
      break;
     case DILocalVariableKind:
      break;
     case DIObjCPropertyKind:
      break;
     case DIImportedEntityKind:
      break;
     case DIMacroKind:
      break;
     case DIMacroFileKind:
      break;
    }

    // Even if this type is uniquable, self-references have to be distinct.
    if (MetadataStatics.hasSelfReference(this)) {
      return replaceWithDistinctImpl();
    }
    return replaceWithUniquedImpl();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithUniquedImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 629,
   FQN="llvm::MDNode::replaceWithUniquedImpl", NM="_ZN4llvm6MDNode22replaceWithUniquedImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode22replaceWithUniquedImplEv")
  //</editor-fold>
  /*friend*//*private*/ MDNode /*P*/ replaceWithUniquedImpl() {
    // Try to uniquify in place.
    MDNode /*P*/ UniquedNode = uniquify();
    if (UniquedNode == this) {
      makeUniqued();
      return this;
    }

    // Collision, so RAUW instead.
    replaceAllUsesWith(UniquedNode);
    deleteAsSubclass();
    return UniquedNode;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::replaceWithDistinctImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 644,
   FQN="llvm::MDNode::replaceWithDistinctImpl", NM="_ZN4llvm6MDNode23replaceWithDistinctImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode23replaceWithDistinctImplEv")
  //</editor-fold>
  /*friend*//*private*//*private*/ MDNode /*P*/ replaceWithDistinctImpl() {
    makeDistinct();
    return this;
  }

/*protected:*/
  /// \brief Set an operand.
  ///
  /// Sets the operand directly, without worrying about uniquing.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::setOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 834,
   FQN="llvm::MDNode::setOperand", NM="_ZN4llvm6MDNode10setOperandEjPNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode10setOperandEjPNS_8MetadataE")
  //</editor-fold>
  protected void setOperand(/*uint*/int I, Metadata /*P*/ New) {
    assert ($less_uint(I, NumOperands));
    mutable_begin().$at(I).reset(New, isUniqued() ? this : (MDNode /*P*/) null);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::storeDistinctInContext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 800,
   FQN="llvm::MDNode::storeDistinctInContext", NM="_ZN4llvm6MDNode22storeDistinctInContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode22storeDistinctInContextEv")
  //</editor-fold>
  protected void storeDistinctInContext() {
    assert (!Context.hasReplaceableUses()) : "Unexpected replaceable uses";
    assert (!(NumUnresolved != 0)) : "Unexpected unresolved nodes";
    Storage = (byte) StorageType.Distinct.getValue();
    assert (isResolved()) : "Expected this to be resolved";

    // Reset the hash.
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid subclass of MDNode");
     case MDTupleKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_true(cast_MDTuple(this), new integral_constant_bool_true());
        break;
      }
     case DILocationKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DILocation(this), new integral_constant_bool_false());
        break;
      }
     case DIExpressionKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIExpression(this), new integral_constant_bool_false());
        break;
      }
     case GenericDINodeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_true(cast_GenericDINode(this), new integral_constant_bool_true());
        break;
      }
     case DISubrangeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DISubrange(this), new integral_constant_bool_false());
        break;
      }
     case DIEnumeratorKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIEnumerator(this), new integral_constant_bool_false());
        break;
      }
     case DIBasicTypeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIBasicType(this), new integral_constant_bool_false());
        break;
      }
     case DIDerivedTypeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIDerivedType(this), new integral_constant_bool_false());
        break;
      }
     case DICompositeTypeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DICompositeType(this), new integral_constant_bool_false());
        break;
      }
     case DISubroutineTypeKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DISubroutineType(this), new integral_constant_bool_false());
        break;
      }
     case DIFileKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIFile(this), new integral_constant_bool_false());
        break;
      }
     case DICompileUnitKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DICompileUnit(this), new integral_constant_bool_false());
        break;
      }
     case DISubprogramKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DISubprogram(this), new integral_constant_bool_false());
        break;
      }
     case DILexicalBlockKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DILexicalBlock(this), new integral_constant_bool_false());
        break;
      }
     case DILexicalBlockFileKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DILexicalBlockFile(this), new integral_constant_bool_false());
        break;
      }
     case DINamespaceKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DINamespace(this), new integral_constant_bool_false());
        break;
      }
     case DIModuleKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIModule(this), new integral_constant_bool_false());
        break;
      }
     case DITemplateTypeParameterKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DITemplateTypeParameter(this), new integral_constant_bool_false());
        break;
      }
     case DITemplateValueParameterKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DITemplateValueParameter(this), new integral_constant_bool_false());
        break;
      }
     case DIGlobalVariableKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIGlobalVariable(this), new integral_constant_bool_false());
        break;
      }
     case DILocalVariableKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DILocalVariable(this), new integral_constant_bool_false());
        break;
      }
     case DIObjCPropertyKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIObjCProperty(this), new integral_constant_bool_false());
        break;
      }
     case DIImportedEntityKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIImportedEntity(this), new integral_constant_bool_false());
        break;
      }
     case DIMacroKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIMacro(this), new integral_constant_bool_false());
        break;
      }
     case DIMacroFileKind:
      {
        std.integral_constant_bool ShouldResetHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchResetHash_T$P_integral_constant_bool_false(cast_DIMacroFile(this), new integral_constant_bool_false());
        break;
      }
    }

    getContext().pImpl.DistinctMDNodes.push_back_T$RR(this);
  }

  /*template <class T, class StoreT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::storeImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/MetadataImpl.h", line = 43,
   FQN="llvm::MDNode::storeImpl", NM="Tpl__ZN4llvm6MDNode9storeImplEPT_NS_8Metadata11StorageTypeERT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode9storeImplEPT_NS_8Metadata11StorageTypeERT0_")
  //</editor-fold>
  protected static </*class*/ T extends MDNode, /*class*/ StoreT extends DenseSet<? super T>> T /*P*/ storeImpl(T /*P*/ N, Metadata.StorageType Storage, final StoreT /*&*/ Store) {
    switch (Storage) {
     case Uniqued:
      Store.insert(N);
      break;
     case Distinct:
      N.storeDistinctInContext();
      break;
     case Temporary:
      break;
    }
    return N;
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::storeImpl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/MetadataImpl.h", line = 29,
   FQN="llvm::MDNode::storeImpl", NM="Tpl__ZN4llvm6MDNode9storeImplEPT_NS_8Metadata11StorageTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode9storeImplEPT_NS_8Metadata11StorageTypeE")
  //</editor-fold>
  protected static </*class*/ T extends MDNode> T /*P*/ storeImpl(T /*P*/ N, Metadata.StorageType Storage) {
    switch (Storage) {
     case Uniqued:
      throw new llvm_unreachable("Cannot unique without a uniquing-store");
     case Distinct:
      N.storeDistinctInContext();
      break;
     case Temporary:
      break;
    }
    return N;
  }

/*private:*/
//<editor-fold defaultstate="collapsed" desc="llvm::MDNode::handleChangedOperand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
          source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 662,
          FQN = "llvm::MDNode::handleChangedOperand", NM = "_ZN4llvm6MDNode20handleChangedOperandEPvPNS_8MetadataE",
          cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode20handleChangedOperandEPvPNS_8MetadataE")
//</editor-fold>
  protected/*private*/ void handleChangedOperand(type$ptr<?>/*void P*/ Ref, Metadata /*P*/ New) {
    /*uint*/
    int Op = ((/*static_cast*/type$ptr<MDOperand> /*P*/) (Ref)).$sub(op_begin());
    assert ($less_uint(Op, getNumOperands())) : "Expected valid operand";
    if (!isUniqued()) {
      // This node is not uniqued.  Just set the operand and be done with it.
      setOperand(Op, New);
      return;
    }

    // This node is uniqued.
    eraseFromStore();

    Metadata /*P*/ Old = getOperand(Op).$Metadata$P();
    setOperand(Op, New);

    // Drop uniquing for self-reference cycles and deleted constants.
    if (New == this || (!(New != null) && (Old != null) && isa_ConstantAsMetadata(Old))) {
      if (!isResolved()) {
        resolve();
      }
      storeDistinctInContext();
      return;
    }

    // Re-unique the node.
    MDNode /*P*/ Uniqued = uniquify();
    if (Uniqued == this) {
      if (!isResolved()) {
        resolveAfterOperandChange(Old, New);
      }
      return;
    }

    // Collision.
    if (!isResolved()) {
      // Still unresolved, so RAUW.
      //
      // First, clear out all operands to prevent any recursion (similar to
      // dropAllReferences(), but we still need the use-list).
      for (/*uint*/int O = 0, E = getNumOperands(); O != E; ++O) {
        setOperand(O, (Metadata /*P*/) null);
      }
      if (Context.hasReplaceableUses()) {
        Context.getReplaceableUses().replaceAllUsesWith(Uniqued);
      }
      deleteAsSubclass();
      return;
    }

    // Store in non-uniqued form if RAUW isn't possible.
    storeDistinctInContext();
  }

  /// Resolve a unique, unresolved node.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::resolve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 539,
   FQN="llvm::MDNode::resolve", NM="_ZN4llvm6MDNode7resolveEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode7resolveEv")
  //</editor-fold>
  private void resolve() {
    assert (isUniqued()) : "Expected this to be uniqued";
    assert (!isResolved()) : "Expected this to be unresolved";

    NumUnresolved = 0;
    dropReplaceableUses();
    assert (isResolved()) : "Expected this to be resolved";
  }


  /// Drop RAUW support, if any.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dropReplaceableUses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 549,
   FQN="llvm::MDNode::dropReplaceableUses", NM="_ZN4llvm6MDNode19dropReplaceableUsesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode19dropReplaceableUsesEv")
  //</editor-fold>
  private void dropReplaceableUses() {
    assert (!(NumUnresolved != 0)) : "Unexpected unresolved operand";

    // Drop any RAUW support.
    if (Context.hasReplaceableUses()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.track(Context.takeReplaceableUses()).$arrow().resolveAllUses(); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::resolveAfterOperandChange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 557,
   FQN="llvm::MDNode::resolveAfterOperandChange", NM="_ZN4llvm6MDNode25resolveAfterOperandChangeEPNS_8MetadataES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode25resolveAfterOperandChangeEPNS_8MetadataES2_")
  //</editor-fold>
  private void resolveAfterOperandChange(Metadata /*P*/ Old, Metadata /*P*/ New) {
    assert (isUniqued()) : "Expected this to be uniqued";
    assert (NumUnresolved != 0) : "Expected unresolved operands";

    // Check if an operand was resolved.
    if (!MetadataStatics.isOperandUnresolved(Old)) {
      if (MetadataStatics.isOperandUnresolved(New)) {
        // An operand was un-resolved!
        ++NumUnresolved;
      }
    } else if (!MetadataStatics.isOperandUnresolved(New)) {
      decrementUnresolvedOperandCount();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::decrementUnresolvedOperandCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 570,
   FQN="llvm::MDNode::decrementUnresolvedOperandCount", NM="_ZN4llvm6MDNode31decrementUnresolvedOperandCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode31decrementUnresolvedOperandCountEv")
  //</editor-fold>
  /*friend*/public/*private*/ void decrementUnresolvedOperandCount() {
    assert (!isResolved()) : "Expected this to be unresolved";
    if (isTemporary()) {
      return;
    }
    assert (isUniqued()) : "Expected this to be uniqued";
    if ((--NumUnresolved != 0)) {
      return;
    }

    // Last unresolved operand has just been resolved.
    dropReplaceableUses();
    assert (isResolved()) : "Expected this to become resolved";
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::countUnresolvedOperands">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 502,
   FQN="llvm::MDNode::countUnresolvedOperands", NM="_ZN4llvm6MDNode23countUnresolvedOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode23countUnresolvedOperandsEv")
  //</editor-fold>
  private void countUnresolvedOperands() {
    assert (NumUnresolved == 0) : "Expected unresolved ops to be uncounted";
    assert (isUniqued()) : "Expected this to be uniqued";
    NumUnresolved = count_if(operands(), (MDOperand Op) -> MetadataStatics.isOperandUnresolved(Op.$Metadata$P()));
  }


  /// \brief Mutate this to be "uniqued".
  ///
  /// Mutate this so that \a isUniqued().
  /// \pre \a isTemporary().
  /// \pre already added to uniquing set.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::makeUniqued">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 508,
   FQN="llvm::MDNode::makeUniqued", NM="_ZN4llvm6MDNode11makeUniquedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode11makeUniquedEv")
  //</editor-fold>
  private void makeUniqued() {
    assert (isTemporary()) : "Expected this to be temporary";
    assert (!isResolved()) : "Expected this to be unresolved";

    // Enable uniquing callbacks.
    for (final MDOperand /*&*/ Op : mutable_operands())  {
      Op.reset(Op.get(), this);
    }

    // Make this 'uniqued'.
    Storage = (byte) StorageType.Uniqued.getValue();
    countUnresolvedOperands();
    if (!(NumUnresolved != 0)) {
      dropReplaceableUses();
      assert (isResolved()) : "Expected this to be resolved";
    }
    assert (isUniqued()) : "Expected this to be uniqued";
  }


  /// \brief Mutate this to be "distinct".
  ///
  /// Mutate this so that \a isDistinct().
  /// \pre \a isTemporary().
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::makeDistinct">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 527,
   FQN="llvm::MDNode::makeDistinct", NM="_ZN4llvm6MDNode12makeDistinctEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode12makeDistinctEv")
  //</editor-fold>
  private void makeDistinct() {
    assert (isTemporary()) : "Expected this to be temporary";
    assert (!isResolved()) : "Expected this to be unresolved";

    // Drop RAUW support and store as a distinct node.
    dropReplaceableUses();
    storeDistinctInContext();
    assert (isDistinct()) : "Expected this to be distinct";
    assert (isResolved()) : "Expected this to be resolved";
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::deleteAsSubclass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 712,
   FQN="llvm::MDNode::deleteAsSubclass", NM="_ZN4llvm6MDNode16deleteAsSubclassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode16deleteAsSubclassEv")
  //</editor-fold>
  /*friend*/public/*private*/ void deleteAsSubclass() {
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid subclass of MDNode");
     case MDTupleKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_MDTuple(this));
      break;
     case DILocationKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DILocation(this));
      break;
     case DIExpressionKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIExpression(this));
      break;
     case GenericDINodeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_GenericDINode(this));
      break;
     case DISubrangeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DISubrange(this));
      break;
     case DIEnumeratorKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIEnumerator(this));
      break;
     case DIBasicTypeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIBasicType(this));
      break;
     case DIDerivedTypeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIDerivedType(this));
      break;
     case DICompositeTypeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DICompositeType(this));
      break;
     case DISubroutineTypeKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DISubroutineType(this));
      break;
     case DIFileKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIFile(this));
      break;
     case DICompileUnitKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DICompileUnit(this));
      break;
     case DISubprogramKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DISubprogram(this));
      break;
     case DILexicalBlockKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DILexicalBlock(this));
      break;
     case DILexicalBlockFileKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DILexicalBlockFile(this));
      break;
     case DINamespaceKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DINamespace(this));
      break;
     case DIModuleKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIModule(this));
      break;
     case DITemplateTypeParameterKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DITemplateTypeParameter(this));
      break;
     case DITemplateValueParameterKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DITemplateValueParameter(this));
      break;
     case DIGlobalVariableKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIGlobalVariable(this));
      break;
     case DILocalVariableKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DILocalVariable(this));
      break;
     case DIObjCPropertyKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIObjCProperty(this));
      break;
     case DIImportedEntityKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIImportedEntity(this));
      break;
     case DIMacroKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIMacro(this));
      break;
     case DIMacroFileKind:
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cast_DIMacroFile(this));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::uniquify">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 745,
   FQN="llvm::MDNode::uniquify", NM="_ZN4llvm6MDNode8uniquifyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode8uniquifyEv")
  //</editor-fold>
  private MDNode /*P*/ uniquify() {
    assert (!MetadataStatics.hasSelfReference(this)) : "Cannot uniquify a self-referencing node";

    // Try to insert into uniquing store.
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid or non-uniquable subclass of MDNode");
     case MDTupleKind:
      {
        MDTuple /*P*/ SubclassThis = cast_MDTuple(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_true(SubclassThis, new integral_constant_bool_true());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.MDTuples);
      }
     case DILocationKind:
      {
        DILocation /*P*/ SubclassThis = cast_DILocation(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DILocations);
      }
     case DIExpressionKind:
      {
        DIExpression /*P*/ SubclassThis = cast_DIExpression(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIExpressions);
      }
     case GenericDINodeKind:
      {
        GenericDINode /*P*/ SubclassThis = cast_GenericDINode(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_true(SubclassThis, new integral_constant_bool_true());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.GenericDINodes);
      }
     case DISubrangeKind:
      {
        DISubrange /*P*/ SubclassThis = cast_DISubrange(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DISubranges);
      }
     case DIEnumeratorKind:
      {
        DIEnumerator /*P*/ SubclassThis = cast_DIEnumerator(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIEnumerators);
      }
     case DIBasicTypeKind:
      {
        DIBasicType /*P*/ SubclassThis = cast_DIBasicType(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIBasicTypes);
      }
     case DIDerivedTypeKind:
      {
        DIDerivedType /*P*/ SubclassThis = cast_DIDerivedType(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIDerivedTypes);
      }
     case DICompositeTypeKind:
      {
        DICompositeType /*P*/ SubclassThis = cast_DICompositeType(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DICompositeTypes);
      }
     case DISubroutineTypeKind:
      {
        DISubroutineType /*P*/ SubclassThis = cast_DISubroutineType(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DISubroutineTypes);
      }
     case DIFileKind:
      {
        DIFile /*P*/ SubclassThis = cast_DIFile(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIFiles);
      }
     case DISubprogramKind:
      {
        DISubprogram /*P*/ SubclassThis = cast_DISubprogram(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DISubprograms);
      }
     case DILexicalBlockKind:
      {
        DILexicalBlock /*P*/ SubclassThis = cast_DILexicalBlock(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DILexicalBlocks);
      }
     case DILexicalBlockFileKind:
      {
        DILexicalBlockFile /*P*/ SubclassThis = cast_DILexicalBlockFile(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DILexicalBlockFiles);
      }
     case DINamespaceKind:
      {
        DINamespace /*P*/ SubclassThis = cast_DINamespace(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DINamespaces);
      }
     case DIModuleKind:
      {
        DIModule /*P*/ SubclassThis = cast_DIModule(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIModules);
      }
     case DITemplateTypeParameterKind:
      {
        DITemplateTypeParameter /*P*/ SubclassThis = cast_DITemplateTypeParameter(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DITemplateTypeParameters);
      }
     case DITemplateValueParameterKind:
      {
        DITemplateValueParameter /*P*/ SubclassThis = cast_DITemplateValueParameter(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DITemplateValueParameters);
      }
     case DIGlobalVariableKind:
      {
        DIGlobalVariable /*P*/ SubclassThis = cast_DIGlobalVariable(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIGlobalVariables);
      }
     case DILocalVariableKind:
      {
        DILocalVariable /*P*/ SubclassThis = cast_DILocalVariable(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DILocalVariables);
      }
     case DIObjCPropertyKind:
      {
        DIObjCProperty /*P*/ SubclassThis = cast_DIObjCProperty(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIObjCPropertys);
      }
     case DIImportedEntityKind:
      {
        DIImportedEntity /*P*/ SubclassThis = cast_DIImportedEntity(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIImportedEntitys);
      }
     case DIMacroKind:
      {
        DIMacro /*P*/ SubclassThis = cast_DIMacro(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIMacros);
      }
     case DIMacroFileKind:
      {
        DIMacroFile /*P*/ SubclassThis = cast_DIMacroFile(this);
        std.integral_constant_bool ShouldRecalculateHash/*J*/= new std.integral_constant_bool(false);
        MDNode.dispatchRecalculateHash_T$P_integral_constant_bool_false(SubclassThis, new integral_constant_bool_false());
        return MetadataStatics.uniquifyImpl(SubclassThis, getContext().pImpl.DIMacroFiles);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::eraseFromStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 764,
   FQN="llvm::MDNode::eraseFromStore", NM="_ZN4llvm6MDNode14eraseFromStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode14eraseFromStoreEv")
  //</editor-fold>
  private void eraseFromStore() {
    switch (Metadata.MetadataKind.valueOf(getMetadataID())) {
     default:
      throw new llvm_unreachable("Invalid or non-uniquable subclass of MDNode");
     case MDTupleKind:
      getContext().pImpl.MDTuples.erase(cast_MDTuple(this));
      break;
     case DILocationKind:
      getContext().pImpl.DILocations.erase(cast_DILocation(this));
      break;
     case DIExpressionKind:
      getContext().pImpl.DIExpressions.erase(cast_DIExpression(this));
      break;
     case GenericDINodeKind:
      getContext().pImpl.GenericDINodes.erase(cast_GenericDINode(this));
      break;
     case DISubrangeKind:
      getContext().pImpl.DISubranges.erase(cast_DISubrange(this));
      break;
     case DIEnumeratorKind:
      getContext().pImpl.DIEnumerators.erase(cast_DIEnumerator(this));
      break;
     case DIBasicTypeKind:
      getContext().pImpl.DIBasicTypes.erase(cast_DIBasicType(this));
      break;
     case DIDerivedTypeKind:
      getContext().pImpl.DIDerivedTypes.erase(cast_DIDerivedType(this));
      break;
     case DICompositeTypeKind:
      getContext().pImpl.DICompositeTypes.erase(cast_DICompositeType(this));
      break;
     case DISubroutineTypeKind:
      getContext().pImpl.DISubroutineTypes.erase(cast_DISubroutineType(this));
      break;
     case DIFileKind:
      getContext().pImpl.DIFiles.erase(cast_DIFile(this));
      break;
     case DISubprogramKind:
      getContext().pImpl.DISubprograms.erase(cast_DISubprogram(this));
      break;
     case DILexicalBlockKind:
      getContext().pImpl.DILexicalBlocks.erase(cast_DILexicalBlock(this));
      break;
     case DILexicalBlockFileKind:
      getContext().pImpl.DILexicalBlockFiles.erase(cast_DILexicalBlockFile(this));
      break;
     case DINamespaceKind:
      getContext().pImpl.DINamespaces.erase(cast_DINamespace(this));
      break;
     case DIModuleKind:
      getContext().pImpl.DIModules.erase(cast_DIModule(this));
      break;
     case DITemplateTypeParameterKind:
      getContext().pImpl.DITemplateTypeParameters.erase(cast_DITemplateTypeParameter(this));
      break;
     case DITemplateValueParameterKind:
      getContext().pImpl.DITemplateValueParameters.erase(cast_DITemplateValueParameter(this));
      break;
     case DIGlobalVariableKind:
      getContext().pImpl.DIGlobalVariables.erase(cast_DIGlobalVariable(this));
      break;
     case DILocalVariableKind:
      getContext().pImpl.DILocalVariables.erase(cast_DILocalVariable(this));
      break;
     case DIObjCPropertyKind:
      getContext().pImpl.DIObjCPropertys.erase(cast_DIObjCProperty(this));
      break;
     case DIImportedEntityKind:
      getContext().pImpl.DIImportedEntitys.erase(cast_DIImportedEntity(this));
      break;
     case DIMacroKind:
      getContext().pImpl.DIMacros.erase(cast_DIMacro(this));
      break;
     case DIMacroFileKind:
      getContext().pImpl.DIMacroFiles.erase(cast_DIMacroFile(this));
      break;
    }
  }

  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dispatchRecalculateHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 986,
   FQN="llvm::MDNode::dispatchRecalculateHash", NM="Tpl__ZN4llvm6MDNode23dispatchRecalculateHashEPT_St17integral_constantIbLb1EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode23dispatchRecalculateHashEPT_St17integral_constantIbLb1EE")
  //</editor-fold>
  private static </*class*/ NodeTy extends MDTuple_or_GenericDINode> void dispatchRecalculateHash_T$P_integral_constant_bool_true(NodeTy /*P*/ N, integral_constant_bool_true $Prm1) {
    N.recalculateHash();
  }

  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dispatchRecalculateHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 990,
   FQN="llvm::MDNode::dispatchRecalculateHash", NM="Tpl__ZN4llvm6MDNode23dispatchRecalculateHashEPT_St17integral_constantIbLb0EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode23dispatchRecalculateHashEPT_St17integral_constantIbLb0EE")
  //</editor-fold>
  private static </*class*/ NodeTy> void dispatchRecalculateHash_T$P_integral_constant_bool_false(NodeTy /*P*/ $Prm0, integral_constant_bool_false $Prm1) {
  }

  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dispatchResetHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 992,
   FQN="llvm::MDNode::dispatchResetHash", NM="Tpl__ZN4llvm6MDNode17dispatchResetHashEPT_St17integral_constantIbLb1EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode17dispatchResetHashEPT_St17integral_constantIbLb1EE")
  //</editor-fold>
  private static </*class*/ NodeTy extends MDTuple_or_GenericDINode> void dispatchResetHash_T$P_integral_constant_bool_true(NodeTy /*P*/ N, integral_constant_bool_true $Prm1) {
    N.setHash(0);
  }

  /*template <class NodeTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::dispatchResetHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 996,
   FQN="llvm::MDNode::dispatchResetHash", NM="Tpl__ZN4llvm6MDNode17dispatchResetHashEPT_St17integral_constantIbLb0EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=Tpl__ZN4llvm6MDNode17dispatchResetHashEPT_St17integral_constantIbLb0EE")
  //</editor-fold>
  private static </*class*/ NodeTy> void dispatchResetHash_T$P_integral_constant_bool_false(NodeTy /*P*/ $Prm0, integral_constant_bool_false $Prm1) {
  }

/*public:*/
  // JAVA: typedef const MDOperand *op_iterator
//  public final class op_iterator extends /*const*/ MDOperand /*P*/ { };
  // JAVA: typedef iterator_range<op_iterator> op_range
//  public final class op_range extends iterator_range</*const*/ MDOperand>{ };

//<editor-fold defaultstate="collapsed" desc="llvm::MDNode::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
          source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1002,
   FQN="llvm::MDNode::op_begin", NM="_ZNK4llvm6MDNode8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode8op_beginEv")
//</editor-fold>
  public type$ptr</*const*/ MDOperand /*P*/> op_begin() /*const*/ {
    return ((/*const_cast*/MDNode /*P*/) (this)).mutable_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1005,
   FQN="llvm::MDNode::op_end", NM="_ZNK4llvm6MDNode6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode6op_endEv")
  //</editor-fold>
  public type$ptr</*const*/ MDOperand /*P*/ > op_end() /*const*/ {
    return ((/*const_cast*/MDNode /*P*/ )(this)).mutable_end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1008,
   FQN="llvm::MDNode::operands", NM="_ZNK4llvm6MDNode8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode8operandsEv")
  //</editor-fold>
  public iterator_range</*const*/ MDOperand> operands() /*const*/ {
    return new iterator_range</*const*/ MDOperand>(op_begin(), op_end());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1010,
   FQN="llvm::MDNode::getOperand", NM="_ZNK4llvm6MDNode10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode10getOperandEj")
  //</editor-fold>
  public /*const*/ MDOperand /*&*/ getOperand(/*uint*/int I) /*const*/ {
    assert ($less_uint(I, NumOperands)) : "Out of range";
    return op_begin().$at(I);
  }


  /// \brief Return number of MDNode operands.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1016,
   FQN="llvm::MDNode::getNumOperands", NM="_ZNK4llvm6MDNode14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm6MDNode14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return NumOperands;
  }


  /// \brief Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1019,
   FQN="llvm::MDNode::classof", NM="_ZN4llvm6MDNode7classofEPKNS_8MetadataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode7classofEPKNS_8MetadataE")
  //</editor-fold>
  public static boolean classof(/*const*/ Metadata /*P*/ MD) {
    switch (Metadata.MetadataKind.valueOf(MD.getMetadataID())) {
     default:
      return false;
     case MDTupleKind:
      return true;
     case DILocationKind:
      return true;
     case DIExpressionKind:
      return true;
     case GenericDINodeKind:
      return true;
     case DISubrangeKind:
      return true;
     case DIEnumeratorKind:
      return true;
     case DIBasicTypeKind:
      return true;
     case DIDerivedTypeKind:
      return true;
     case DICompositeTypeKind:
      return true;
     case DISubroutineTypeKind:
      return true;
     case DIFileKind:
      return true;
     case DICompileUnitKind:
      return true;
     case DISubprogramKind:
      return true;
     case DILexicalBlockKind:
      return true;
     case DILexicalBlockFileKind:
      return true;
     case DINamespaceKind:
      return true;
     case DIModuleKind:
      return true;
     case DITemplateTypeParameterKind:
      return true;
     case DITemplateValueParameterKind:
      return true;
     case DIGlobalVariableKind:
      return true;
     case DILocalVariableKind:
      return true;
     case DIObjCPropertyKind:
      return true;
     case DIImportedEntityKind:
      return true;
     case DIMacroKind:
      return true;
     case DIMacroFileKind:
      return true;
    }
  }


  /// \brief Check whether MDNode is a vtable access.

  /// \brief Check whether MDNode is a vtable access.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::isTBAAVtableAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 372,
   FQN="llvm::MDNode::isTBAAVtableAccess", NM="_ZNK4llvm6MDNode18isTBAAVtableAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZNK4llvm6MDNode18isTBAAVtableAccessEv")
  //</editor-fold>
  public boolean isTBAAVtableAccess() /*const*/ {
    if (!isStructPathTBAA(this)) {
      if ($less_uint(getNumOperands(), 1)) {
        return false;
      }
      {
        MDString /*P*/ Tag1 = dyn_cast_MDString(getOperand(0));
        if ((Tag1 != null)) {
          if ($eq_StringRef(Tag1.getString(), /*STRINGREF_STR*/"vtable pointer")) {
            return true;
          }
        }
      }
      return false;
    }

    // For struct-path aware TBAA, we use the access type of the tag.
    if ($less_uint(getNumOperands(), 2)) {
      return false;
    }
    MDNode /*P*/ Tag = cast_or_null_MDNode(getOperand(1));
    if (!(Tag != null)) {
      return false;
    }
    {
      MDString /*P*/ Tag1 = dyn_cast_MDString(Tag.getOperand(0));
      if ((Tag1 != null)) {
        if ($eq_StringRef(Tag1.getString(), /*STRINGREF_STR*/"vtable pointer")) {
          return true;
        }
      }
    }
    return false;
  }



  /// \brief Methods for metadata merging.
  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::concatenate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 859,
   FQN="llvm::MDNode::concatenate", NM="_ZN4llvm6MDNode11concatenateEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode11concatenateEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ concatenate(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null)) {
      return B;
    }
    if (!(B != null)) {
      return A;
    }

    SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    MDs.reserve(A.getNumOperands() + B.getNumOperands());
    MDs.append_T(A.op_begin(), A.op_end(), (MDOperand Op) -> Op.$Metadata$P());
    MDs.append_T(B.op_begin(), B.op_end(), (MDOperand Op) -> Op.$Metadata$P());

    // FIXME: This preserves long-standing behaviour, but is it really the right
    // behaviour?  Or was that an unintended side-effect of node uniquing?
    return MetadataStatics.getOrSelfReference(A.getContext(), new ArrayRef<Metadata /*P*/ >(MDs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::intersect">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 875,
   FQN="llvm::MDNode::intersect", NM="_ZN4llvm6MDNode9intersectEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode9intersectEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ intersect(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null) || !(B != null)) {
      return null;
    }

    SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    for (MDOperand $Op : A.operands())  {
      Metadata /*P*/ MD = $Op.$Metadata$P();
      if ($noteq_ptr(std.find(B.op_begin(), B.op_end(), MD), B.op_end())) {
        MDs.push_back(MD);
      }
    }

    // FIXME: This preserves long-standing behaviour, but is it really the right
    // behaviour?  Or was that an unintended side-effect of node uniquing?
    return MetadataStatics.getOrSelfReference(A.getContext(), new ArrayRef<Metadata /*P*/ >(MDs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getMostGenericTBAA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 396,
   FQN="llvm::MDNode::getMostGenericTBAA", NM="_ZN4llvm6MDNode18getMostGenericTBAAEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm6MDNode18getMostGenericTBAAEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ getMostGenericTBAA(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null) || !(B != null)) {
      return null;
    }
    if (A == B) {
      return A;
    }

    // For struct-path aware TBAA, we use the access type of the tag.
    boolean StructPath = isStructPathTBAA(A) && isStructPathTBAA(B);
    if (StructPath) {
      A = cast_or_null_MDNode(A.getOperand(1));
      if (!(A != null)) {
        return null;
      }
      B = cast_or_null_MDNode(B.getOperand(1));
      if (!(B != null)) {
        return null;
      }
    }

    SmallSetVector<MDNode /*P*/ > PathA/*J*/= new SmallSetVector<MDNode /*P*/ >(4, (MDNode /*P*/ ) null);
    MDNode /*P*/ T = A;
    while ((T != null)) {
      if ((PathA.count(T) != 0)) {
        report_fatal_error($("Cycle found in TBAA metadata."));
      }
      PathA.insert(T);
      T = $greatereq_uint(T.getNumOperands(), 2) ? cast_or_null_MDNode(T.getOperand(1)) : null;
    }

    SmallSetVector<MDNode /*P*/ > PathB/*J*/= new SmallSetVector<MDNode /*P*/ >(4, (MDNode /*P*/ ) null);
    T = B;
    while ((T != null)) {
      if ((PathB.count(T) != 0)) {
        report_fatal_error($("Cycle found in TBAA metadata."));
      }
      PathB.insert(T);
      T = $greatereq_uint(T.getNumOperands(), 2) ? cast_or_null_MDNode(T.getOperand(1)) : null;
    }

    int IA = PathA.size() - 1;
    int IB = PathB.size() - 1;

    MDNode /*P*/ Ret = null;
    while (IA >= 0 && IB >= 0) {
      if (PathA.$at(IA) == PathB.$at(IB)) {
        Ret = PathA.$at(IA);
      } else {
        break;
      }
      --IA;
      --IB;
    }
    if (!StructPath) {
      return Ret;
    }
    if (!(Ret != null)) {
      return null;
    }
    // We need to convert from a type node to a tag node.
    Type /*P*/ Int64 = IntegerType.get(A.getContext(), 64);
    Metadata /*P*/ Ops[/*3*/] = new Metadata /*P*/  [/*3*/] {
      Ret, Ret,
      ConstantAsMetadata.get(ConstantInt.get(Int64, $int2ulong(0)))};
    return MDNode.get(A.getContext(), new ArrayRef<Metadata /*P*/ >(Ops, true));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getMostGenericFPMath">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 903,
   FQN="llvm::MDNode::getMostGenericFPMath", NM="_ZN4llvm6MDNode20getMostGenericFPMathEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode20getMostGenericFPMathEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ getMostGenericFPMath(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null) || !(B != null)) {
      return null;
    }
    
    APFloat AVal = new APFloat(MdconstGlobals.extract$ValidPointer(ConstantFP.class, A.getOperand(0)).getValueAPF());
    APFloat BVal = new APFloat(MdconstGlobals.extract$ValidPointer(ConstantFP.class, B.getOperand(0)).getValueAPF());
    if (AVal.compare(BVal) == APFloat.cmpResult.cmpLessThan) {
      return A;
    }
    return B;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getMostGenericRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 951,
   FQN="llvm::MDNode::getMostGenericRange", NM="_ZN4llvm6MDNode19getMostGenericRangeEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode19getMostGenericRangeEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ getMostGenericRange(MDNode /*P*/ A, MDNode /*P*/ B) {
    // Given two ranges, we want to compute the union of the ranges. This
    // is slightly complitade by having to combine the intervals and merge
    // the ones that overlap.
    if (!(A != null) || !(B != null)) {
      return null;
    }
    if (A == B) {
      return A;
    }
    
    // First, walk both lists in older of the lower boundary of each interval.
    // At each step, try to merge the new interval to the last one we adedd.
    SmallVector<ConstantInt /*P*/ > EndPoints/*J*/= new SmallVector<ConstantInt /*P*/ >(4, (ConstantInt /*P*/ )null);
    int AI = 0;
    int BI = 0;
    int AN = $div_uint(A.getNumOperands(), 2);
    int BN = $div_uint(B.getNumOperands(), 2);
    while (AI < AN && BI < BN) {
      ConstantInt /*P*/ ALow = MdconstGlobals.extract$ValidPointer(ConstantInt.class, A.getOperand(2 * AI));
      ConstantInt /*P*/ BLow = MdconstGlobals.extract$ValidPointer(ConstantInt.class, B.getOperand(2 * BI));
      if (ALow.getValue().slt(BLow.getValue())) {
        MetadataStatics.addRange(EndPoints, ALow, 
            MdconstGlobals.extract$ValidPointer(ConstantInt.class, A.getOperand(2 * AI + 1)));
        ++AI;
      } else {
        MetadataStatics.addRange(EndPoints, BLow, 
            MdconstGlobals.extract$ValidPointer(ConstantInt.class, B.getOperand(2 * BI + 1)));
        ++BI;
      }
    }
    while (AI < AN) {
      MetadataStatics.addRange(EndPoints, MdconstGlobals.extract$ValidPointer(ConstantInt.class, A.getOperand(2 * AI)), 
          MdconstGlobals.extract$ValidPointer(ConstantInt.class, A.getOperand(2 * AI + 1)));
      ++AI;
    }
    while (BI < BN) {
      MetadataStatics.addRange(EndPoints, MdconstGlobals.extract$ValidPointer(ConstantInt.class, B.getOperand(2 * BI)), 
          MdconstGlobals.extract$ValidPointer(ConstantInt.class, B.getOperand(2 * BI + 1)));
      ++BI;
    }
    
    // If we have more than 2 ranges (4 endpoints) we have to try to merge
    // the last and first ones.
    /*uint*/int Size = EndPoints.size();
    if ($greater_uint(Size, 4)) {
      ConstantInt /*P*/ FB = EndPoints.$at(0);
      ConstantInt /*P*/ FE = EndPoints.$at(1);
      if (MetadataStatics.tryMergeRange(EndPoints, FB, FE)) {
        for (/*uint*/int i = 0; $less_uint(i, Size - 2); ++i) {
          EndPoints.$set(i, EndPoints.$at(i + 2));
        }
        EndPoints.resize(Size - 2);
      }
    }
    
    // If in the end we have a single range, it is possible that it is now the
    // full range. Just drop the metadata in that case.
    if (EndPoints.size() == 2) {
      ConstantRange Range = null;
      try {
        Range/*J*/= new ConstantRange(new APInt(EndPoints.$at(0).getValue()), new APInt(EndPoints.$at(1).getValue()));
        if (Range.isFullSet()) {
          return null;
        }
      } finally {
        if (Range != null) { Range.$destroy(); }
      }
    }
    
    SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(4, (Metadata /*P*/ )null);
    MDs.reserve(EndPoints.size());
    for (ConstantInt /*P*/ I : EndPoints)  {
      MDs.push_back(ConstantAsMetadata.get(I));
    }
    return MDNode.get(A.getContext(), new ArrayRef<Metadata /*P*/ >(MDs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getMostGenericAliasScope">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 889,
   FQN="llvm::MDNode::getMostGenericAliasScope", NM="_ZN4llvm6MDNode24getMostGenericAliasScopeEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode24getMostGenericAliasScopeEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ getMostGenericAliasScope(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null) || !(B != null)) {
      return null;
    }

    SmallVector<Metadata /*P*/ > MDs/*J*/= new SmallVector<Metadata /*P*/ >(JD$T.INSTANCE, 4, B.op_begin(), B.op_end(), (Metadata /*P*/ )null, (MDOperand O) -> O.$Metadata$P());
    for (MDOperand O : A.operands()) {
      Metadata /*P*/ MD = O.$Metadata$P();
      if ($eq_ptr(std.find(B.op_begin(), B.op_end(), MD), B.op_end())) {
        MDs.push_back(MD);
      }
    }

    // FIXME: This preserves long-standing behaviour, but is it really the right
    // behaviour?  Or was that an unintended side-effect of node uniquing?
    return MetadataStatics.getOrSelfReference(A.getContext(), new ArrayRef<Metadata /*P*/ >(MDs, true));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNode::getMostGenericAlignmentOrDereferenceable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1023,
   FQN="llvm::MDNode::getMostGenericAlignmentOrDereferenceable", NM="_ZN4llvm6MDNode40getMostGenericAlignmentOrDereferenceableEPS0_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm6MDNode40getMostGenericAlignmentOrDereferenceableEPS0_S1_")
  //</editor-fold>
  public static MDNode /*P*/ getMostGenericAlignmentOrDereferenceable(MDNode /*P*/ A, MDNode /*P*/ B) {
    if (!(A != null) || !(B != null)) {
      return null;
    }
    
    ConstantInt /*P*/ AVal = MdconstGlobals.extract$ValidPointer(ConstantInt.class, A.getOperand(0));
    ConstantInt /*P*/ BVal = MdconstGlobals.extract$ValidPointer(ConstantInt.class, B.getOperand(0));
    if ($less_ulong(AVal.getZExtValue(), BVal.getZExtValue())) {
      return A;
    }
    return B;
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static final ThreadLocalThisSupplier<MDNode> MemorySupplier = ThreadLocalThisSupplier.Create(MDNode::assertThisConsumedByCtor, MDNode.class.getName(), false);
  private final type$ptr<?> $This = MemorySupplier.consumeAssignedMemory(this);
  /*friend*/type$ptr<?> $This$Ptr() { return $This; }

  private static boolean assertThisConsumedByCtor(MDNode createdInstance, type$ptr Mem) {
    assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
    assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
    return true;
  }

  private static <T extends MDNode> T callConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> $Ctor) {
    T createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
    assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
    return createdInstance;
  }
  protected static <T extends MDNode>/*void P*/ T $new(/*uint*/int NumOps, New$ConstructorCallback<T> $Ctor) {
    return $new(Integer.MIN_VALUE, NumOps, $Ctor);
  }

  @Override
  public void $delete() {
    MDNode.$delete(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "NumOperands=" + NumOperands // NOI18N
              + ", NumUnresolved=" + NumUnresolved // NOI18N
              + ", Context=" + Context // NOI18N
              + super.toString(); // NOI18N
  }
}
