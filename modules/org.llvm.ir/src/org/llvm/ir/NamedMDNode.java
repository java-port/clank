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


//===----------------------------------------------------------------------===//
/// \brief A tuple of MDNodes.
///
/// Despite its name, a NamedMDNode isn't itself an MDNode. NamedMDNodes belong
/// to modules, have names, and contain lists of MDNodes.
///
/// TODO: Inherit from Metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1249,
 FQN="llvm::NamedMDNode", NM="_ZN4llvm11NamedMDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNodeE")
//</editor-fold>
public class NamedMDNode implements /*public*/ ilist_node<NamedMDNode>, Destructors.ClassWithDestructor {
  /*friend  struct ilist_traits<NamedMDNode>*/
  /*friend  class LLVMContextImpl*/
  /*friend  class Module*/
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::NamedMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1253,
   FQN="llvm::NamedMDNode::NamedMDNode", NM="_ZN4llvm11NamedMDNodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNodeC1ERKS0_")
  //</editor-fold>
  /*friend*//*private*/ NamedMDNode(final /*const*/ NamedMDNode /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}


  private std.string Name;
  private Module /*P*/ Parent;
  private Object/*void P*/ Operands; // SmallVector<TrackingMDRef, 4>

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::setParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1259,
   FQN="llvm::NamedMDNode::setParent", NM="_ZN4llvm11NamedMDNode9setParentEPNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode9setParentEPNS_6ModuleE")
  //</editor-fold>
  /*friend*//*private*/ void setParent(Module /*P*/ M) {
    Parent = M;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::NamedMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1042,
   FQN="llvm::NamedMDNode::NamedMDNode", NM="_ZN4llvm11NamedMDNodeC1ERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNodeC1ERKNS_5TwineE")
  //</editor-fold>
  /*friend*//*private*/ NamedMDNode(final /*const*/ Twine /*&*/ N) {
    // : ilist_node<NamedMDNode>(), Name(N.str()), Parent(null), Operands(new SmallVector<TrackingMDRef, 4>())
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.Name = N.str();
    this.Parent = null;
    this.Operands = new SmallVector<TrackingMDRef>(4, new TrackingMDRef());
    //END JInit
  }



  /*template <class T1, class T2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1263,
   FQN="llvm::NamedMDNode::op_iterator_impl", NM="_ZN4llvm11NamedMDNode16op_iterator_implE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implE")
  //</editor-fold>
  public static class op_iterator_impl</*class*/ T1 extends MDNode, /*class*/ T2>  implements /*public*/ std.iterator<std.bidirectional_iterator_tag, T2>, type$iterator<op_iterator_impl, T1> {
    private /*const*/ NamedMDNode /*P*/ Node;
    private /*uint*/int Idx;
    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::op_iterator_impl<T1, T2>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1268,
     FQN="llvm::NamedMDNode::op_iterator_impl::op_iterator_impl<T1, T2>", NM="_ZN4llvm11NamedMDNode16op_iterator_implC1EPKS0_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implC1EPKS0_j")
    //</editor-fold>
    private op_iterator_impl(/*const*/ NamedMDNode /*P*/ N, /*uint*/int i) {
      // : Node(N), Idx(i)
      //START JInit
      this.Node = N;
      this.Idx = i;
      //END JInit
    }


    /*friend  class NamedMDNode*/
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::op_iterator_impl<T1, T2>">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1273,
     FQN="llvm::NamedMDNode::op_iterator_impl::op_iterator_impl<T1, T2>", NM="_ZN4llvm11NamedMDNode16op_iterator_implC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implC1Ev")
    //</editor-fold>
    public op_iterator_impl() {
      // : Node(null), Idx(0)
      //START JInit
      this.Node = null;
      this.Idx = 0;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1275,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator==", NM="_ZNK4llvm11NamedMDNode16op_iterator_impleqERKNS0_16op_iterator_implIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode16op_iterator_impleqERKNS0_16op_iterator_implIT_T0_EE")
    //</editor-fold>
    public boolean $eq(final /*const*/ op_iterator_impl<T1, T2> /*&*/ o) /*const*/ {
      return Native.$eq(Idx, o.Idx);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1276,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator!=", NM="_ZNK4llvm11NamedMDNode16op_iterator_implneERKNS0_16op_iterator_implIT_T0_EE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode16op_iterator_implneERKNS0_16op_iterator_implIT_T0_EE")
    //</editor-fold>
    public boolean $noteq(final /*const*/ op_iterator_impl<T1, T2> /*&*/ o) /*const*/ {
      return Native.$noteq(Idx, o.Idx);
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1277,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator++", NM="_ZN4llvm11NamedMDNode16op_iterator_implppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implppEv")
    //</editor-fold>
    public op_iterator_impl<T1, T2> /*&*/ $preInc() {
      ++Idx;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1281,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator++", NM="_ZN4llvm11NamedMDNode16op_iterator_implppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implppEi")
    //</editor-fold>
    public op_iterator_impl<T1, T2> $postInc(int $Prm0) {
      op_iterator_impl<T1, T2> tmp/*J*/= /*ParenList*/new op_iterator_impl<T1, T2>(/*Deref*/this);
      $preInc();
      return tmp;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator--">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1286,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator--", NM="_ZN4llvm11NamedMDNode16op_iterator_implmmEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implmmEv")
    //</editor-fold>
    public op_iterator_impl<T1, T2> /*&*/ $preDec() {
      --Idx;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator--">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1290,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator--", NM="_ZN4llvm11NamedMDNode16op_iterator_implmmEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode16op_iterator_implmmEi")
    //</editor-fold>
    public op_iterator_impl<T1, T2> $postDec(int $Prm0) {
      op_iterator_impl<T1, T2> tmp/*J*/= /*ParenList*/new op_iterator_impl<T1, T2>(/*Deref*/this);
      $preDec();
      return tmp;
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_iterator_impl::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1296,
     FQN="llvm::NamedMDNode::op_iterator_impl::operator*", NM="_ZNK4llvm11NamedMDNode16op_iterator_impldeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode16op_iterator_impldeEv")
    //</editor-fold>
    public T1 $star() /*const*/ {
      return (T1) Node.getOperand(Idx);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private op_iterator_impl(op_iterator_impl other) { this.Node = other.Node; this.Idx = other.Idx; }

    public op_iterator_impl clone() { return new op_iterator_impl(this); }

    public @Override boolean $eq(Object other) { return $eq((op_iterator_impl) other); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////

    @Override public String toString() {
      return "" + "Node=" + Node // NOI18N
                + ", Idx=" + Idx // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  /// \brief Drop all references and remove the node from parent module.
  /// \brief Drop all references and remove the node from parent module.
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::eraseFromParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1068,
   FQN="llvm::NamedMDNode::eraseFromParent", NM="_ZN4llvm11NamedMDNode15eraseFromParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNode15eraseFromParentEv")
  //</editor-fold>
  public void eraseFromParent() {
    getParent().eraseNamedMetadata(this);
  }



  /// \brief Remove all uses and clear node vector.

  /// \brief Remove all uses and clear node vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::dropAllReferences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1072,
   FQN="llvm::NamedMDNode::dropAllReferences", NM="_ZN4llvm11NamedMDNode17dropAllReferencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNode17dropAllReferencesEv")
  //</editor-fold>
  public void dropAllReferences() {
    MetadataStatics.getNMDOps(Operands).clear();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::~NamedMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1046,
   FQN="llvm::NamedMDNode::~NamedMDNode", NM="_ZN4llvm11NamedMDNodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNodeD0Ev")
  //</editor-fold>
  public void $destroy() {
    dropAllReferences();
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)$AddrOf(MetadataStatics.getNMDOps(Operands)));
    //START JDestroy
    Name.$destroy();
    ilist_node.super.$destroy$ilist_node();
    //END JDestroy
  }



  /// \brief Get the module that holds this named metadata collection.
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1309,
   FQN="llvm::NamedMDNode::getParent", NM="_ZN4llvm11NamedMDNode9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode9getParentEv")
  //</editor-fold>
  public /*inline*/ Module /*P*/ getParent() {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1310,
   FQN="llvm::NamedMDNode::getParent", NM="_ZNK4llvm11NamedMDNode9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode9getParentEv")
  //</editor-fold>
  public /*inline*/ /*const*/ Module /*P*/ getParent$Const() /*const*/ {
    return Parent;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1055,
   FQN="llvm::NamedMDNode::getOperand", NM="_ZNK4llvm11NamedMDNode10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11NamedMDNode10getOperandEj")
  //</editor-fold>
  public MDNode /*P*/ getOperand(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, getNumOperands())) : "Invalid Operand number!";
    Metadata /*P*/ N = MetadataStatics.getNMDOps(Operands).$at(i).get();
    return cast_or_null_MDNode(N);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1051,
   FQN="llvm::NamedMDNode::getNumOperands", NM="_ZNK4llvm11NamedMDNode14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11NamedMDNode14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return (/*uint*/int)MetadataStatics.getNMDOps(Operands).size();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::addOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1061,
   FQN="llvm::NamedMDNode::addOperand", NM="_ZN4llvm11NamedMDNode10addOperandEPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNode10addOperandEPNS_6MDNodeE")
  //</editor-fold>
  public void addOperand(MDNode /*P*/ M) {
    MetadataStatics.getNMDOps(Operands).emplace_back(new TrackingMDRef(M));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::setOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1063,
   FQN="llvm::NamedMDNode::setOperand", NM="_ZN4llvm11NamedMDNode10setOperandEjPNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZN4llvm11NamedMDNode10setOperandEjPNS_6MDNodeE")
  //</editor-fold>
  public void setOperand(/*uint*/int I, MDNode /*P*/ New) {
    assert ($less_uint(I, getNumOperands())) : "Invalid operand number";
    MetadataStatics.getNMDOps(Operands).$at(I).reset(New);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Metadata.cpp", line = 1076,
   FQN="llvm::NamedMDNode::getName", NM="_ZNK4llvm11NamedMDNode7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Metadata.cpp -nm=_ZNK4llvm11NamedMDNode7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(Name);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3315,
   FQN="llvm::NamedMDNode::print", NM="_ZNK4llvm11NamedMDNode5printERNS_11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode5printERNS_11raw_ostreamEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS) /*const*/ {
    print(ROS, false);
  }
  public void print(final raw_ostream /*&*/ ROS, boolean IsForDebug/*= false*/) /*const*/ {
    SlotTracker SlotTable = null;
    formatted_raw_ostream OS = null;
    AssemblyWriter W = null;
    try {
      SlotTable/*J*/= new SlotTracker(getParent$Const());
      OS/*J*/= new formatted_raw_ostream(ROS);
      W/*J*/= new AssemblyWriter(OS, SlotTable, getParent$Const(), (AssemblyAnnotationWriter /*P*/ )null, IsForDebug);
      W.printNamedMDNode(this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      if (SlotTable != null) { SlotTable.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::print">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3322,
   FQN="llvm::NamedMDNode::print", NM="_ZNK4llvm11NamedMDNode5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode5printERNS_11raw_ostreamERNS_17ModuleSlotTrackerEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ ROS, final ModuleSlotTracker /*&*/ MST) /*const*/ {
    print(ROS, MST,
       false);
  }
  public void print(final raw_ostream /*&*/ ROS, final ModuleSlotTracker /*&*/ MST,
       boolean IsForDebug/*= false*/) /*const*/ {
    Optional<SlotTracker> LocalST = null;
    formatted_raw_ostream OS = null;
    AssemblyWriter W = null;
    try {
      LocalST/*J*/= new Optional<SlotTracker>();
      SlotTracker /*P*/ SlotTable;
      {
        SlotTracker /*P*/ ST = MST.getMachine();
        if ((ST != null)) {
          SlotTable = ST;
        } else {
          LocalST.emplace(new SlotTracker(getParent$Const()));
          SlotTable = $AddrOf(LocalST.$star());
        }
      }

      OS/*J*/= new formatted_raw_ostream(ROS);
      W/*J*/= new AssemblyWriter(OS, $Deref(SlotTable), getParent$Const(), (AssemblyAnnotationWriter /*P*/ )null, IsForDebug);
      W.printNamedMDNode(this);
    } finally {
      if (W != null) { W.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      if (LocalST != null) { LocalST.$destroy(); }
    }
  }


  // NamedMDNode::dump() - Allow printing of NamedMDNodes from the debugger.
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3553,
   FQN="llvm::NamedMDNode::dump", NM="_ZNK4llvm11NamedMDNode4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs(), /*IsForDebug=*/ true);
  }


  // ---------------------------------------------------------------------------
  // Operand Iterator interface...
  //
  // JAVA: typedef op_iterator_impl<MDNode *, MDNode> op_iterator
//  public final class op_iterator extends op_iterator_impl<MDNode /*P*/ , MDNode>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1326,
   FQN="llvm::NamedMDNode::op_begin", NM="_ZN4llvm11NamedMDNode8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode8op_beginEv")
  //</editor-fold>
  public op_iterator_impl<MDNode /*P*/ , MDNode> op_begin() {
    return new op_iterator_impl<MDNode /*P*/ , MDNode>(this, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1327,
   FQN="llvm::NamedMDNode::op_end", NM="_ZN4llvm11NamedMDNode6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode6op_endEv")
  //</editor-fold>
  public op_iterator_impl<MDNode /*P*/ , MDNode> op_end() {
    return new op_iterator_impl<MDNode /*P*/ , MDNode>(this, getNumOperands());
  }


  // JAVA: typedef op_iterator_impl<const MDNode *, MDNode> const_op_iterator
//  public final class const_op_iterator extends op_iterator_impl</*const*/ MDNode /*P*/ , MDNode>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1330,
   FQN="llvm::NamedMDNode::op_begin", NM="_ZNK4llvm11NamedMDNode8op_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode8op_beginEv")
  //</editor-fold>
  public op_iterator_impl</*const*/ MDNode /*P*/ , MDNode> op_begin$Const() /*const*/ {
    return new op_iterator_impl</*const*/ MDNode /*P*/ , MDNode>(this, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::op_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1331,
   FQN="llvm::NamedMDNode::op_end", NM="_ZNK4llvm11NamedMDNode6op_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode6op_endEv")
  //</editor-fold>
  public op_iterator_impl</*const*/ MDNode /*P*/ , MDNode> op_end$Const() /*const*/ {
    return new op_iterator_impl</*const*/ MDNode /*P*/ , MDNode>(this, getNumOperands());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1333,
   FQN="llvm::NamedMDNode::operands", NM="_ZN4llvm11NamedMDNode8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm11NamedMDNode8operandsEv")
  //</editor-fold>
  public /*inline*/ iterator_range<MDNode /*P*/ > operands() {
    return make_range(op_begin(), op_end());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::NamedMDNode::operands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 1336,
   FQN="llvm::NamedMDNode::operands", NM="_ZNK4llvm11NamedMDNode8operandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm11NamedMDNode8operandsEv")
  //</editor-fold>
  public /*inline*/ iterator_range</*const*/ MDNode /*P*/ > operands$Const() /*const*/ {
    return make_range(op_begin$Const(), op_end$Const());
  }


  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }

  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Parent=" + Parent // NOI18N
              + ", Operands=" + NativeTrace.getIdentityStr(Operands) // NOI18N
              + super.toString(); // NOI18N
  }
}
