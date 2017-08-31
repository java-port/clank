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

package org.llvm.ir.impl;

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

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 424,
 FQN="(anonymous namespace)::TypePrinting", NM="_ZN12_GLOBAL__N_112TypePrintingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrintingE")
//</editor-fold>
public class TypePrinting implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::TypePrinting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 425,
   FQN="(anonymous namespace)::TypePrinting::TypePrinting", NM="_ZN12_GLOBAL__N_112TypePrintingC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrintingC1ERKS0_")
  //</editor-fold>
  protected/*private*/ TypePrinting(final /*const*/ TypePrinting /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 426,
   FQN="(anonymous namespace)::TypePrinting::operator=", NM="_ZN12_GLOBAL__N_112TypePrintingaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrintingaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ TypePrinting /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/

  /// NamedTypes - The named types that are used by the current module.
  public TypeFinder NamedTypes;

  /// NumberedTypes - The numbered types, along with their value.
  public DenseMapTypeUInt<StructType /*P*/ > NumberedTypes;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::TypePrinting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 435,
   FQN="(anonymous namespace)::TypePrinting::TypePrinting", NM="_ZN12_GLOBAL__N_112TypePrintingC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrintingC1Ev")
  //</editor-fold>
  public TypePrinting() {
    // : NamedTypes(), NumberedTypes()/* = default*/
    //START JInit
    this.NamedTypes = new TypeFinder();
    this.NumberedTypes = new DenseMapTypeUInt<StructType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }


  // namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::incorporateTypes">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 445,
   FQN="(anonymous namespace)::TypePrinting::incorporateTypes", NM="_ZN12_GLOBAL__N_112TypePrinting16incorporateTypesERKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrinting16incorporateTypesERKN4llvm6ModuleE")
  //</editor-fold>
  public void incorporateTypes(final /*const*/ Module /*&*/ M) {
    NamedTypes.run(M, false);

    // The list of struct types we got back includes all the struct types, split
    // the unnamed ones out to a numbering and remove the anonymous structs.
    /*uint*/int NextNumber = 0;

    std.vector.iterator<StructType /*P*/ > NextToUse = NamedTypes.begin();
    for (std.vector.iterator<StructType /*P*/ > I= NamedTypes.begin() , E = NamedTypes.end(); $noteq___normal_iterator$C(I, E); I.$preInc()) {
      StructType /*P*/ STy = I.$star();

      // Ignore anonymous types.
      if (STy.isLiteral()) {
        continue;
      }
      if (STy.getName().empty()) {
        NumberedTypes.$set(STy, NextNumber++);
      } else {
        NextToUse.$postInc(0).star$ref().$set(STy);
      }
    }

    NamedTypes.erase(new std.vector.iterator<StructType /*P*/ >(NextToUse), NamedTypes.end());
  }



  /// CalcTypeName - Write the specified type to the specified raw_ostream, making
  /// use of type names or up references to shorten the type name where possible.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 472,
   FQN="(anonymous namespace)::TypePrinting::print", NM="_ZN12_GLOBAL__N_112TypePrinting5printEPN4llvm4TypeERNS1_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrinting5printEPN4llvm4TypeERNS1_11raw_ostreamE")
  //</editor-fold>
  public void print(Type /*P*/ Ty, final raw_ostream /*&*/ OS) {
    switch (Ty.getTypeID()) {
     case VoidTyID:
      OS.$out(/*KEEP_STR*/$void);
      return;
     case HalfTyID:
      OS.$out(/*KEEP_STR*/$half);
      return;
     case FloatTyID:
      OS.$out(/*KEEP_STR*/$float);
      return;
     case DoubleTyID:
      OS.$out(/*KEEP_STR*/$double);
      return;
     case X86_FP80TyID:
      OS.$out(/*KEEP_STR*/"x86_fp80");
      return;
     case FP128TyID:
      OS.$out(/*KEEP_STR*/"fp128");
      return;
     case PPC_FP128TyID:
      OS.$out(/*KEEP_STR*/"ppc_fp128");
      return;
     case LabelTyID:
      OS.$out(/*KEEP_STR*/"label");
      return;
     case MetadataTyID:
      OS.$out(/*KEEP_STR*/"metadata");
      return;
     case X86_MMXTyID:
      OS.$out(/*KEEP_STR*/"x86_mmx");
      return;
     case TokenTyID:
      OS.$out(/*KEEP_STR*/"token");
      return;
     case IntegerTyID:
      OS.$out_char($$i).$out_uint(cast_IntegerType(Ty).getBitWidth());
      return;
     case FunctionTyID:
      {
        FunctionType /*P*/ FTy = cast_FunctionType(Ty);
        print(FTy.getReturnType(), OS);
        OS.$out(/*KEEP_STR*/" (");
        for (type$ptr<Type /*P*/ /*const*/ /*P*/> I = $tryClone(FTy.param_begin()),
            /*P*/ /*const*/ /*P*/ E = $tryClone(FTy.param_end()); $noteq_ptr(I, E); I.$preInc()) {
          if ($noteq_ptr(I, FTy.param_begin())) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          print(I.$star(), OS);
        }
        if (FTy.isVarArg()) {
          if ((FTy.getNumParams() != 0)) {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$ELLIPSIS);
        }
        OS.$out_char($$RPAREN);
        return;
      }
     case StructTyID:
      {
        StructType /*P*/ STy = cast_StructType(Ty);
        if (STy.isLiteral()) {
          printStructBody(STy, OS);
          /*JAVA:return*/return;
        }
        if (!STy.getName().empty()) {
          AsmWriterStatics.PrintLLVMName(OS, STy.getName(), PrefixType.LocalPrefix);
          /*JAVA:return*/return;
        }

        DenseMapIteratorTypeUInt<StructType /*P*/ /*P*/> I = NumberedTypes.find(STy);
        if (I.$noteq(/*NO_ITER_COPY*/NumberedTypes.end())) {
          OS.$out_char($$PERCENT).$out_uint(I.$arrow().second);
        } else { // Not enumerated, print the hex address.
          OS.$out(/*KEEP_STR*/"%\"type ").$out(STy).$out_char($$DBL_QUOTE);
        }
        return;
      }
     case PointerTyID:
      {
        PointerType /*P*/ PTy = cast_PointerType(Ty);
        print(PTy.getElementType(), OS);
        {
          /*uint*/int AddressSpace = PTy.getAddressSpace();
          if ((AddressSpace != 0)) {
            OS.$out(/*KEEP_STR*/" addrspace(").$out_uint(AddressSpace).$out_char($$RPAREN);
          }
        }
        OS.$out_char($$STAR);
        return;
      }
     case ArrayTyID:
      {
        ArrayType /*P*/ ATy = cast_ArrayType(Ty);
        OS.$out_char($$LSQUARE).$out_ullong(ATy.getNumElements()).$out(/*KEEP_STR*/" x ");
        print(ATy.getElementType(), OS);
        OS.$out_char($$RSQUARE);
        return;
      }
     case VectorTyID:
      {
        VectorType /*P*/ PTy = cast_VectorType(Ty);
        OS.$out(/*KEEP_STR*/$LT).$out_uint(PTy.getNumElements()).$out(/*KEEP_STR*/" x ");
        print(PTy.getElementType(), OS);
        OS.$out_char($$GT);
        return;
      }
    }
    throw new llvm_unreachable("Invalid TypeID");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::printStructBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 548,
   FQN="(anonymous namespace)::TypePrinting::printStructBody", NM="_ZN12_GLOBAL__N_112TypePrinting15printStructBodyEPN4llvm10StructTypeERNS1_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrinting15printStructBodyEPN4llvm10StructTypeERNS1_11raw_ostreamE")
  //</editor-fold>
  public void printStructBody(StructType /*P*/ STy, final raw_ostream /*&*/ OS) {
    if (STy.isOpaque()) {
      OS.$out(/*KEEP_STR*/"opaque");
      return;
    }
    if (STy.isPacked()) {
      OS.$out_char($$LT);
    }
    if (STy.getNumElements() == 0) {
      OS.$out(/*KEEP_STR*/"{}");
    } else {
      type$ptr<Type /*P*/ /*const*/ /*P*/> I = $tryClone(STy.element_begin());
      OS.$out(/*KEEP_STR*/"{ ");
      print(I.$postInc().$star(), OS);
      for (type$ptr<Type /*P*/ /*const*/ /*P*/> E = $tryClone(STy.element_end()); $noteq_ptr(I, E); I.$preInc()) {
        OS.$out(/*KEEP_STR*/$COMMA_SPACE);
        print(I.$star(), OS);
      }

      OS.$out(/*KEEP_STR*/" }");
    }
    if (STy.isPacked()) {
      OS.$out_char($$GT);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypePrinting::~TypePrinting">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 424,
   FQN="(anonymous namespace)::TypePrinting::~TypePrinting", NM="_ZN12_GLOBAL__N_112TypePrintingD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_112TypePrintingD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    NumberedTypes.$destroy();
    NamedTypes.$destroy();
    //END JDestroy
  }


  @Override public String toString() {
    return "" + "NamedTypes=" + NamedTypes // NOI18N
              + ", NumberedTypes=" + NumberedTypes; // NOI18N
  }
}
