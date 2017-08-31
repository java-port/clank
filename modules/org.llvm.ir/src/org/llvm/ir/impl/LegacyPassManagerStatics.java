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

import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.cl.*;
import org.llvm.pass.*;
import static org.llvm.cl.ClGlobals.clEnumValEnd;
import org.llvm.cl.aliases.optBool;
import static org.llvm.pass.IrLlvmGlobals.TimePassesIsEnabled$ref;
import org.llvm.support.sys.SmartMutex;
import org.llvm.support.sys.sys;


//<editor-fold defaultstate="collapsed" desc="static type LegacyPassManagerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.LegacyPassManagerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL10PrintAfter;_ZL11PrintBefore;_ZL11TheTimeInfo;_ZL12EnableTiming;_ZL13PassDebugging;_ZL13PrintAfterAll;_ZL14PrintBeforeAll;_ZL14PrintFuncsListB5cxx11;_ZL20ShouldPrintAfterPassPKN4llvm8PassInfoE;_ZL21ShouldPrintBeforePassPKN4llvm8PassInfoE;_ZL28ShouldPrintBeforeOrAfterPassPKN4llvm8PassInfoERNS_2cl4listIS2_bNS_14PassNameParserEEE;_ZN12_GLOBAL__N_1L15TimingInfoMutexE; -static-type=LegacyPassManagerStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class LegacyPassManagerStatics {

//<editor-fold defaultstate="collapsed" desc="PassDebugging">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 51,
 FQN="PassDebugging", NM="_ZL13PassDebugging",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL13PassDebugging")
//</editor-fold>
public static optEnum< PassDebugLevel> PassDebugging/*J*/= new optEnum< PassDebugLevel>( PassDebugLevel::valueOf, $("debug-pass"), OptionHidden.Hidden, 
    new desc($("Print PassManager debugging information")), 
    ClGlobals.values($("Disabled"), ((int)(PassDebugLevel.Disabled.getValue())), $("disable debug output"), 
        $("Arguments"), ((int)(PassDebugLevel.Arguments.getValue())), $("print pass arguments to pass to 'opt'"), 
        $("Structure"), ((int)(PassDebugLevel.Structure.getValue())), $("print pass structure before run()"), 
        $("Executions"), ((int)(PassDebugLevel.Executions.getValue())), $("print pass name before it is executed"), 
        $("Details"), ((int)(PassDebugLevel.Details.getValue())), $("print pass details when it is executed"), 
        (reinterpret_cast(Object/*void P*/ .class, clEnumValEnd))));

// Print IR out before/after specified passes.
//<editor-fold defaultstate="collapsed" desc="PrintBefore">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 68,
 FQN="PrintBefore", NM="_ZL11PrintBefore",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL11PrintBefore")
//</editor-fold>
public static listTypePtrBool</*const*/ PassInfo /*P*/> PrintBefore/*J*/= new listTypePtrBool</*const*/ PassInfo /*P*/>(PassNameParser::new, $("print-before"), 
    new desc($("Print IR before specified passes")), 
    OptionHidden.Hidden);
//<editor-fold defaultstate="collapsed" desc="PrintAfter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 73,
 FQN="PrintAfter", NM="_ZL10PrintAfter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL10PrintAfter")
//</editor-fold>
public static listTypePtrBool</*const*/ PassInfo> PrintAfter/*J*/= new listTypePtrBool</*const*/ PassInfo /*P*/>(PassNameParser::new, $("print-after"), 
    new desc($("Print IR after specified passes")), 
    OptionHidden.Hidden);
//<editor-fold defaultstate="collapsed" desc="PrintBeforeAll">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 78,
 FQN="PrintBeforeAll", NM="_ZL14PrintBeforeAll",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL14PrintBeforeAll")
//</editor-fold>
public static optBool PrintBeforeAll/*J*/= new optBool(/*false, */$("print-before-all"), 
    new desc($("Print IR before each pass")), 
    ClGlobals.init$Bool(false));
//<editor-fold defaultstate="collapsed" desc="PrintAfterAll">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 82,
 FQN="PrintAfterAll", NM="_ZL13PrintAfterAll",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL13PrintAfterAll")
//</editor-fold>
public static optBool PrintAfterAll/*J*/= new optBool(/*false, */$("print-after-all"), 
    new desc($("Print IR after each pass")), 
    ClGlobals.init$Bool(false));
//<editor-fold defaultstate="collapsed" desc="PrintFuncsList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 87,
 FQN="PrintFuncsList", NM="_ZL14PrintFuncsList",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL14PrintFuncsList")
//</editor-fold>
public static listStringBool PrintFuncsList/*J*/= new listStringBool($("filter-print-funcs"), new value_desc($("function names")), 
    new desc($("Only print IR for functions whose name match this for all print-[before|after][-all] options")), 
    MiscFlags.CommaSeparated);

/// This is a helper to determine whether to print IR before or
/// after a pass.
//<editor-fold defaultstate="collapsed" desc="ShouldPrintBeforeOrAfterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 97,
 FQN="ShouldPrintBeforeOrAfterPass", NM="_ZL28ShouldPrintBeforeOrAfterPassPKN4llvm8PassInfoERNS_2cl4listIS2_bNS_14PassNameParserEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL28ShouldPrintBeforeOrAfterPassPKN4llvm8PassInfoERNS_2cl4listIS2_bNS_14PassNameParserEEE")
//</editor-fold>
public static boolean ShouldPrintBeforeOrAfterPass(/*const*/ PassInfo /*P*/ PI, 
                            final listTypePtrBool</*const*/ PassInfo /*P*/> /*&*/ PassesToPrint) {
  for (/*const*/ PassInfo /*P*/ PassInf : PassesToPrint) {
    if ((PassInf != null)) {
      if ($eq_ptr(PassInf.getPassArgument(), PI.getPassArgument())) {
        return true;
      }
    }
  }
  return false;
}


/// This is a utility to check whether a pass should have IR dumped
/// before it.
//<editor-fold defaultstate="collapsed" desc="ShouldPrintBeforePass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 110,
 FQN="ShouldPrintBeforePass", NM="_ZL21ShouldPrintBeforePassPKN4llvm8PassInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL21ShouldPrintBeforePassPKN4llvm8PassInfoE")
//</editor-fold>
public static boolean ShouldPrintBeforePass(/*const*/ PassInfo /*P*/ PI) {
  return PrintBeforeAll.$T() || ShouldPrintBeforeOrAfterPass(PI, PrintBefore);
}


/// This is a utility to check whether a pass should have IR dumped
/// after it.
//<editor-fold defaultstate="collapsed" desc="ShouldPrintAfterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 116,
 FQN="ShouldPrintAfterPass", NM="_ZL20ShouldPrintAfterPassPKN4llvm8PassInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL20ShouldPrintAfterPassPKN4llvm8PassInfoE")
//</editor-fold>
public static boolean ShouldPrintAfterPass(/*const*/ PassInfo /*P*/ PI) {
  return PrintAfterAll.$T() || ShouldPrintBeforeOrAfterPass(PI, PrintAfter);
}


//===----------------------------------------------------------------------===//
/// TimingInfo Class - This class is used to calculate information about the
/// amount of time each pass takes to execute.  This only happens when
/// -time-passes is enabled on the command line.
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TimingInfoMutex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 450,
 FQN="(anonymous namespace)::TimingInfoMutex", NM="_ZN12_GLOBAL__N_1L15TimingInfoMutexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN12_GLOBAL__N_1L15TimingInfoMutexE")
//</editor-fold>
public static ManagedStatic<SmartMutex/*<true>*/> TimingInfoMutex/*J*/= new ManagedStatic<SmartMutex/*<true>*/>(sys.StaticSmartMutexTrue);
// End of anon namespace
//<editor-fold defaultstate="collapsed" desc="TheTimeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 488,
 FQN="TheTimeInfo", NM="_ZL11TheTimeInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL11TheTimeInfo")
//</editor-fold>
public static TimingInfo /*P*/ TheTimeInfo;
//<editor-fold defaultstate="collapsed" desc="EnableTiming">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1744,
 FQN="EnableTiming", NM="_ZL12EnableTiming",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZL12EnableTiming")
//</editor-fold>
public static optBool EnableTiming/*J*/= new optBool(opt.StorageKind.External, $("time-passes"), ClGlobals.location(TimePassesIsEnabled$ref), 
    new desc($("Time each pass, printing elapsed time for each on exit")));
} // END OF class LegacyPassManagerStatics
