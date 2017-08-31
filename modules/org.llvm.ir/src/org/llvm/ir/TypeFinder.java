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


/// TypeFinder - Walk over a module, identifying all of the types that are
/// used by the module.
//<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 31,
 FQN="llvm::TypeFinder", NM="_ZN4llvm10TypeFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinderE")
//</editor-fold>
public class TypeFinder implements Iterable<StructType /*P*/>, Destructors.ClassWithDestructor {
  // To avoid walking constant expressions multiple times and other IR
  // objects, we keep several helper maps.
  private DenseSet</*const*/ Value /*P*/ > VisitedConstants;
  private DenseSet</*const*/ MDNode /*P*/ > VisitedMetadata;
  private DenseSet<Type /*P*/ > VisitedTypes;

  private std.vector<StructType /*P*/ > StructTypes;
  private boolean OnlyNamed;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::TypeFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 42,
   FQN="llvm::TypeFinder::TypeFinder", NM="_ZN4llvm10TypeFinderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinderC1Ev")
  //</editor-fold>
  public TypeFinder() {
    // : VisitedConstants(), VisitedMetadata(), VisitedTypes(), StructTypes(), OnlyNamed(false)
    //START JInit
    this.VisitedConstants = new DenseSet</*const*/ Value /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.VisitedMetadata = new DenseSet</*const*/ MDNode /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.VisitedTypes = new DenseSet<Type /*P*/ >(DenseMapInfo$LikePtr.$Info());
    this.StructTypes = new std.vector<StructType /*P*/ >((StructType /*P*/ )null);
    this.OnlyNamed = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::run">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp", line = 23,
   FQN="llvm::TypeFinder::run", NM="_ZN4llvm10TypeFinder3runERKNS_6ModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp -nm=_ZN4llvm10TypeFinder3runERKNS_6ModuleEb")
  //</editor-fold>
  public void run(final /*const*/ Module /*&*/ M, boolean onlyNamed) {
    OnlyNamed = onlyNamed;

    // Get types from global variables.
    for (ilist_iterator</*const*/ GlobalVariable> I = M.global_begin$Const(),
        E = M.global_end$Const(); I.$noteq(E); I.$preInc()) {
      incorporateType(I.$arrow().getType());
      if (I.$arrow().hasInitializer()) {
        incorporateValue(I.$arrow().getInitializer$Const());
      }
    }

    // Get types from aliases.
    for (ilist_iterator</*const*/ GlobalAlias> I = M.alias_begin$Const(),
        E = M.alias_end$Const(); I.$noteq(E); I.$preInc()) {
      incorporateType(I.$arrow().getType());
      {
        /*const*/ Value /*P*/ Aliasee = I.$arrow().getAliasee$Const();
        if ((Aliasee != null)) {
          incorporateValue(Aliasee);
        }
      }
    }

    // Get types from functions.
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDForInst/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    for (final /*const*/ Function /*&*/ FI : M) {
      incorporateType(FI.getType());

      for (final /*const*/ Use /*&*/ U : FI.operands$Const())  {
        incorporateValue(U.get());
      }

      // First incorporate the arguments.
      for (ilist_iterator</*const*/ Argument> AI = FI.arg_begin$Const(), AE = FI.arg_end$Const();
           AI.$noteq(AE); AI.$preInc())  {
        incorporateValue($AddrOf(AI.$star()));
      }

      for (final /*const*/ BasicBlock /*&*/ BB : FI)  {
        for (final /*const*/ Instruction /*&*/ I : BB) {
          // Incorporate the type of the instruction.
          incorporateType(I.getType());

          // Incorporate non-instruction operand types. (We are incorporating all
          // instructions with this loop.)
          for (/*const*/type$ptr<Use /*P*/> OI = $tryClone(I.op_begin$Const()), /*P*/ OE = $tryClone(I.op_end$Const());
               $noteq_ptr(OI, OE); OI.$preInc())  {
            if (((OI.$star().$Value$P()) != null) && !isa_Instruction(OI)) {
              incorporateValue(OI.$star().$Value$P());
            }
          }

          // Incorporate types hiding in metadata.
          I.getAllMetadataOtherThanDebugLoc(MDForInst);
          for (/*uint*/int i = 0, e = MDForInst.size(); i != e; ++i)  {
            incorporateMDNode(MDForInst.$at(i).second);
          }

          MDForInst.clear();
        }
      }
    }

    for (ilist_iterator</*const*/ NamedMDNode> I = M.named_metadata_begin$Const(),
        E = M.named_metadata_end$Const(); I.$noteq(E); I.$preInc()) {
      /*const*/ NamedMDNode /*P*/ NMD = $AddrOf(I.$star());
      for (/*uint*/int i = 0, e = NMD.getNumOperands(); i != e; ++i)  {
        incorporateMDNode(NMD.getOperand(i));
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp", line = 84,
   FQN="llvm::TypeFinder::clear", NM="_ZN4llvm10TypeFinder5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp -nm=_ZN4llvm10TypeFinder5clearEv")
  //</editor-fold>
  public void clear() {
    VisitedConstants.clear();
    VisitedTypes.clear();
    StructTypes.clear();
  }



  // JAVA: typedef std::vector<StructType *>::iterator iterator
//  public final class iterator extends std.vector.iterator<StructType /*P*/ >{ };
  // JAVA: typedef std::vector<StructType *>::const_iterator const_iterator
//  public final class const_iterator extends std.vector.iterator</*const*/ StructType /*P*/ >{ };

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 50,
   FQN="llvm::TypeFinder::begin", NM="_ZN4llvm10TypeFinder5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinder5beginEv")
  //</editor-fold>
  public std.vector.iterator<StructType /*P*/ > begin() {
    return StructTypes.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 51,
   FQN="llvm::TypeFinder::end", NM="_ZN4llvm10TypeFinder3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinder3endEv")
  //</editor-fold>
  public std.vector.iterator<StructType /*P*/ > end() {
    return StructTypes.end();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 53,
   FQN="llvm::TypeFinder::begin", NM="_ZNK4llvm10TypeFinder5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm10TypeFinder5beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ StructType /*P*/ > begin$Const() /*const*/ {
    return StructTypes.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 54,
   FQN="llvm::TypeFinder::end", NM="_ZNK4llvm10TypeFinder3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm10TypeFinder3endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ StructType /*P*/ > end$Const() /*const*/ {
    return StructTypes.end$Const();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 56,
   FQN="llvm::TypeFinder::empty", NM="_ZNK4llvm10TypeFinder5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm10TypeFinder5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return StructTypes.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 57,
   FQN="llvm::TypeFinder::size", NM="_ZNK4llvm10TypeFinder4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZNK4llvm10TypeFinder4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return StructTypes.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 58,
   FQN="llvm::TypeFinder::erase", NM="_ZN4llvm10TypeFinder5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10StructTypeESt6vectorIS4_SaIS4_EEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinder5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10StructTypeESt6vectorIS4_SaIS4_EEEES9_")
  //</editor-fold>
  public std.vector.iterator<StructType /*P*/ > erase(std.vector.iterator<StructType /*P*/ > I, std.vector.iterator<StructType /*P*/ > E) {
    return StructTypes.erase(new std.vector.iterator</*const*/ StructType /*P*/ >(I), new std.vector.iterator</*const*/ StructType /*P*/ >(E));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 60,
   FQN="llvm::TypeFinder::operator[]", NM="_ZN4llvm10TypeFinderixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinderixEj")
  //</editor-fold>
  public StructType /*P*/ /*&*/ $at(/*uint*/int Idx) {
    return StructTypes.$at(Idx);
  }

/*private:*/
  /// incorporateType - This method adds the type to the list of used
  /// structures if it's not in there already.
  /// incorporateType - This method adds the type to the list of used
  /// structures if it's not in there already.

  /// incorporateType - This method adds the type to the list of used structures
  /// if it's not in there already.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::incorporateType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp", line = 92,
   FQN="llvm::TypeFinder::incorporateType", NM="_ZN4llvm10TypeFinder15incorporateTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp -nm=_ZN4llvm10TypeFinder15incorporateTypeEPNS_4TypeE")
  //</editor-fold>
  private void incorporateType(Type /*P*/ Ty) {
    // Check to see if we've already visited this type.
    if (!VisitedTypes.insert(Ty).second) {
      return;
    }

    SmallVector<Type /*P*/ > TypeWorklist/*J*/= new SmallVector<Type /*P*/ >(4, (Type /*P*/ )null);
    TypeWorklist.push_back(Ty);
    do {
      Ty = TypeWorklist.pop_back_val();
      {

        // If this is a structure or opaque type, add a name for the type.
        StructType /*P*/ STy = dyn_cast_StructType(Ty);
        if ((STy != null)) {
          if (!OnlyNamed || STy.hasName()) {
            StructTypes.push_back_T$C$R(STy);
          }
        }
      }

      // Add all unvisited subtypes to worklist for processing
      for (std.reverse_iterator<Type /*P*/ /*const*/> I = Ty.subtype_rbegin(),
          E = Ty.subtype_rend();
           $noteq_reverse_iterator$C(I, E); I.$preInc())  {
        if (VisitedTypes.insert(I.$star()).second) {
          TypeWorklist.push_back(I.$star());
        }
      }
    } while (!TypeWorklist.empty());
  }



  /// incorporateValue - This method is used to walk operand lists finding types
  /// hiding in constant expressions and other operands that won't be walked in
  /// other ways.  GlobalValues, basic blocks, instructions, and inst operands
  /// are all explicitly enumerated.

  /// incorporateValue - This method is used to walk operand lists finding types
  /// hiding in constant expressions and other operands that won't be walked in
  /// other ways.  GlobalValues, basic blocks, instructions, and inst operands
  /// are all explicitly enumerated.

  /// incorporateValue - This method is used to walk operand lists finding types
  /// hiding in constant expressions and other operands that won't be walked in
  /// other ways.  GlobalValues, basic blocks, instructions, and inst operands are
  /// all explicitly enumerated.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::incorporateValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp", line = 120,
   FQN="llvm::TypeFinder::incorporateValue", NM="_ZN4llvm10TypeFinder16incorporateValueEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp -nm=_ZN4llvm10TypeFinder16incorporateValueEPKNS_5ValueE")
  //</editor-fold>
  private void incorporateValue(/*const*/ Value /*P*/ V) {
    {
      /*const*/ MetadataAsValue /*P*/ M = dyn_cast_MetadataAsValue(V);
      if ((M != null)) {
        {
          /*const*/ MDNode /*P*/ N = dyn_cast_MDNode(M.getMetadata());
          if ((N != null)) {
            incorporateMDNode(N);
            /*JAVA:return*/return;
          }
        }
        {
          /*const*/ ValueAsMetadata /*P*/ MDV = dyn_cast_ValueAsMetadata(M.getMetadata());
          if ((MDV != null)) {
            incorporateValue(MDV.getValue());
            /*JAVA:return*/return;
          }
        }
        return;
      }
    }
    if (!isa_Constant(V) || isa_GlobalValue(V)) {
      return;
    }

    // Already visited?
    if (!VisitedConstants.insert(V).second) {
      return;
    }

    // Check this type.
    incorporateType(V.getType());

    // If this is an instruction, we incorporate it separately.
    if (isa_Instruction(V)) {
      return;
    }

    // Look in operands for types.
    /*const*/ User /*P*/ U = cast_User(V);
    for (/*const*/type$ptr<Use /*P*/> I = $tryClone(U.op_begin$Const()),
        /*P*/ E = $tryClone(U.op_end$Const()); $noteq_ptr(I, E); I.$preInc())  {
      incorporateValue(I.$star().$Value$P());
    }
  }



  /// incorporateMDNode - This method is used to walk the operands of an MDNode
  /// to find types hiding within.

  /// incorporateMDNode - This method is used to walk the operands of an MDNode
  /// to find types hiding within.

  /// incorporateMDNode - This method is used to walk the operands of an MDNode to
  /// find types hiding within.
  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::incorporateMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp", line = 151,
   FQN="llvm::TypeFinder::incorporateMDNode", NM="_ZN4llvm10TypeFinder17incorporateMDNodeEPKNS_6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/TypeFinder.cpp -nm=_ZN4llvm10TypeFinder17incorporateMDNodeEPKNS_6MDNodeE")
  //</editor-fold>
  private void incorporateMDNode(/*const*/ MDNode /*P*/ V) {
    // Already visited?
    if (!VisitedMetadata.insert(V).second) {
      return;
    }

    // Look in operands for types.
    for (/*uint*/int i = 0, e = V.getNumOperands(); i != e; ++i) {
      Metadata /*P*/ Op = V.getOperand(i).$Metadata$P();
      if (!(Op != null)) {
        continue;
      }
      {
        MDNode /*P*/ N = dyn_cast_MDNode(Op);
        if ((N != null)) {
          incorporateMDNode(N);
          continue;
        }
      }
      {
        ConstantAsMetadata /*P*/ C = dyn_cast_ConstantAsMetadata(Op);
        if ((C != null)) {
          incorporateValue(C.getValue());
          continue;
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::TypeFinder::~TypeFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/TypeFinder.h", line = 31,
   FQN="llvm::TypeFinder::~TypeFinder", NM="_ZN4llvm10TypeFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN4llvm10TypeFinderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StructTypes.$destroy();
    VisitedTypes.$destroy();
    VisitedMetadata.$destroy();
    VisitedConstants.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public java.util.Iterator<StructType /*P*/> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  public type$ref<StructType /*P*/ /*&*/> re$at(/*uint*/int Idx) {
    return StructTypes.ref$at(Idx);
  } 
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "VisitedConstants=" + VisitedConstants // NOI18N
              + ", VisitedMetadata=" + VisitedMetadata // NOI18N
              + ", VisitedTypes=" + VisitedTypes // NOI18N
              + ", StructTypes=" + StructTypes // NOI18N
              + ", OnlyNamed=" + OnlyNamed; // NOI18N
  }
}
