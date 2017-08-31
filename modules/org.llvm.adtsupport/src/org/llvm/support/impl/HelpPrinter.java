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

package org.llvm.support.impl;

import org.clank.java.*;
import static org.clank.java.std.exit;
import static org.clank.java.std.strlen;
import org.clank.support.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$noteq_ptr;
import static org.clank.support.Unsigned.$greater_uint;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;
import static org.llvm.cl.ClGlobals.TopLevelSubCommand;
import static org.llvm.support.impl.CommandLineStatics.GlobalParser;
import static org.llvm.support.impl.CommandLineStatics.sortOpts;
import static org.llvm.support.impl.CommandLineStatics.sortSubCommands;
import static org.llvm.support.llvm.outs;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1721,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1478,
 FQN="(anonymous namespace)::HelpPrinter", NM="_ZN12_GLOBAL__N_111HelpPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinterE")
//</editor-fold>
public class HelpPrinter implements type$ref<Boolean>, Destructors.ClassWithDestructor {
/*protected:*/
  protected final/*protected*/ /*const*/boolean ShowHidden;
  // JAVA: typedef SmallVector<std::pair<const char *, Option *>, 128> StrOptionPairVector
//  public final class StrOptionPairVector extends SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >>{ };
  // JAVA: typedef SmallVector<std::pair<const char *, SubCommand *>, 128> StrSubCommandPairVector
//  public final class StrSubCommandPairVector extends SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ >>{ };
  // Print the options. Opts is assumed to be alphabetically sorted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter::printOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1729,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1484,
   FQN="(anonymous namespace)::HelpPrinter::printOptions", NM="_ZN12_GLOBAL__N_111HelpPrinter12printOptionsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl6OptionEELj128EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinter12printOptionsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl6OptionEELj128EEEj")
  //</editor-fold>
  protected /*virtual*/ void printOptions(final SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >> /*&*/ Opts, /*size_t*/int MaxArgLen) {
    for (/*size_t*/int i = 0, e = Opts.size(); i != e; ++i)  {
      Opts.$at(i).second.printOptionInfo(MaxArgLen);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter::printSubCommands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1734,
   FQN="(anonymous namespace)::HelpPrinter::printSubCommands", NM="_ZN12_GLOBAL__N_111HelpPrinter16printSubCommandsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl10SubCommandEELj128EEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinter16printSubCommandsERN4llvm11SmallVectorISt4pairIPKcPNS1_2cl10SubCommandEELj128EEEj")
  //</editor-fold>
  protected void printSubCommands(final SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ >> /*&*/ Subs, /*size_t*/int MaxSubLen) {
    for (final /*const*/std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ > /*&*/ S : Subs) {
      outs().$out(/*KEEP_STR*/"  ").$out(S.first);
      if (Native.$bool(S.second.getDescription())) {
        outs().indent(MaxSubLen - strlen(S.first));
        outs().$out(/*KEEP_STR*/" - ").$out(S.second.getDescription());
      }
      outs().$out(/*KEEP_STR*/$LF);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter::HelpPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1746,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1490,
   FQN="(anonymous namespace)::HelpPrinter::HelpPrinter", NM="_ZN12_GLOBAL__N_111HelpPrinterC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinterC1Eb")
  //</editor-fold>
  public /*explicit*/ HelpPrinter(boolean showHidden) {
    // : ShowHidden(showHidden) 
    //START JInit
    this.ShowHidden = showHidden;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter::~HelpPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1747,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1491,
   FQN="(anonymous namespace)::HelpPrinter::~HelpPrinter", NM="_ZN12_GLOBAL__N_111HelpPrinterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinterD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  // Invoke the printer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HelpPrinter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1750,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1494,
   FQN="(anonymous namespace)::HelpPrinter::operator=", NM="_ZN12_GLOBAL__N_111HelpPrinteraSEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_111HelpPrinteraSEb")
  //</editor-fold>
  public void $assign(boolean Value) {
    if (!Value) {
      return;
    }
  
    SubCommand /*P*/ Sub = GlobalParser.$arrow().getActiveSubCommand();
    final StringMap<Option /*P*//* , MallocAllocator*/> /*&*/ OptionsMap = Sub.OptionsMap;
    final SmallVector<Option /*P*//*, 4*/> /*&*/ PositionalOpts = Sub.PositionalOpts;
    final Option /*P*/ /*&*/ ConsumeAfterOpt = Sub.ConsumeAfterOpt;
    
    SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >> Opts/*J*/= new SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >>(128, new std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >());
    sortOpts(OptionsMap, Opts, ShowHidden);
    
    SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ >> Subs/*J*/= new SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ >>(128, new std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ >());
    sortSubCommands(GlobalParser.$arrow().RegisteredSubCommands, Subs);
    if (Native.$bool(GlobalParser.$arrow().ProgramOverview)) {
      outs().$out(/*KEEP_STR*/"OVERVIEW: ").$out(GlobalParser.$arrow().ProgramOverview).$out(/*KEEP_STR*/$LF);
    }
    if (Sub == $AddrOf(TopLevelSubCommand.$star())) {
      outs().$out(/*KEEP_STR*/"USAGE: ").$out(GlobalParser.$arrow().ProgramName).$out(
          /*KEEP_STR*/" [subcommand] [options]"
      );
    } else {
      if ($noteq_ptr(Sub.getDescription(), null)) {
        outs().$out(/*KEEP_STR*/"SUBCOMMAND '").$out(Sub.getName()).$out(
            /*KEEP_STR*/"': "
        ).$out(Sub.getDescription()).$out(/*KEEP_STR*/"\n\n");
      }
      outs().$out(/*KEEP_STR*/"USAGE: ").$out(GlobalParser.$arrow().ProgramName).$out(/*KEEP_STR*/$SPACE).$out(Sub.getName()).$out(
          /*KEEP_STR*/" [options]"
      );
    }
    
    for (Option /*P*/ Opt : PositionalOpts) {
      if (Opt.hasArgStr()) {
        outs().$out(/*KEEP_STR*/" --").$out(/*NO_COPY*/Opt.ArgStr);
      }
      outs().$out(/*KEEP_STR*/$SPACE).$out(/*NO_COPY*/Opt.HelpStr);
    }
    
    // Print the consume after option info if it exists...
    if ((ConsumeAfterOpt != null)) {
      outs().$out(/*KEEP_STR*/$SPACE).$out(/*NO_COPY*/ConsumeAfterOpt.HelpStr);
    }
    if (Sub == $AddrOf(TopLevelSubCommand.$star()) && $greater_uint(Subs.size(), 2)) {
      // Compute the maximum subcommand length...
      /*size_t*/int MaxSubLen = 0;
      for (/*size_t*/int i = 0, e = Subs.size(); i != e; ++i)  {
        MaxSubLen = std.max(MaxSubLen, strlen(Subs.$at(i).first));
      }
      
      outs().$out(/*KEEP_STR*/"\n\n");
      outs().$out(/*KEEP_STR*/"SUBCOMMANDS:\n\n");
      printSubCommands(Subs, MaxSubLen);
      outs().$out(/*KEEP_STR*/$LF);
      outs().$out(/*KEEP_STR*/"  Type \"").$out(GlobalParser.$arrow().ProgramName).$out(
          /*KEEP_STR*/" <subcommand> -help\" to get more help on a specific subcommand"
      );
    }
    
    outs().$out(/*KEEP_STR*/"\n\n");
    
    // Compute the maximum argument length...
    /*size_t*/int MaxArgLen = 0;
    for (/*size_t*/int i = 0, e = Opts.size(); i != e; ++i)  {
      MaxArgLen = std.max(MaxArgLen, Opts.$at(i).second.getOptionWidth());
    }
    
    outs().$out(/*KEEP_STR*/"OPTIONS:\n");
    printOptions(Opts, MaxArgLen);
    
    // Print any extra help the user has declared.
    for (/*const*/char$ptr/*char P*/ I : GlobalParser.$arrow().MoreHelp)  {
      outs().$out(I);
    }
    GlobalParser.$arrow().MoreHelp.clear();
    
    // Halt the program since help information was printed
    exit(0);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Boolean $deref() {
    return ShowHidden;
  }

  @Override
  public Boolean $set(Boolean value) {
    assert ShowHidden == value;
    return value;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "ShowHidden=" + ShowHidden + '}' + System.identityHashCode(this);
  }
}
