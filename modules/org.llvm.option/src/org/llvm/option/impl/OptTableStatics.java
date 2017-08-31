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

package org.llvm.option.impl;

import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;


//<editor-fold defaultstate="collapsed" desc="static type OptTableStatics">
@Converted(kind = Converted.Kind.MANUAL, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL7isInputRKN4llvm9StringSetINS_15MallocAllocatorEEENS_9StringRefE;_ZL11matchOptionPKN4llvm3opt8OptTable4InfoENS_9StringRefEb;_ZL17getOptionHelpNameRKN4llvm3opt8OptTableENS0_12OptSpecifierE;_ZL19PrintHelpOptionListRN4llvm11raw_ostreamENS_9StringRefERSt6vectorISt4pairISsPKcESaIS7_EE;_ZL18getOptionHelpGroupRKN4llvm3opt8OptTableENS0_12OptSpecifierE; -static-type=OptTableStatics")
//</editor-fold>
public final class OptTableStatics {

//<editor-fold defaultstate="collapsed" desc="isInput">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 162,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 168,
 FQN = "isInput", NM = "_ZL7isInputRKN4llvm9StringSetINS_15MallocAllocatorEEENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL7isInputRKN4llvm9StringSetINS_15MallocAllocatorEEENS_9StringRefE")
//</editor-fold>
public static boolean isInput(/*const*/StringSet/*&*/ Prefixes, StringRef Arg) {
  if ($eq_StringRef(Arg, StringRef.R$MINUS)) {
    return true;
  }
  for (StringMapIteratorChar I = $tryClone(Prefixes.begin()), E = $tryClone(Prefixes.end()); I.$noteq(E); I.$preInc())  {
    if (Arg.startswith(I.$arrow().getKey())) {
      return false;
    }
  }
  return true;
}


/// \returns Matched size. 0 means no match.
//<editor-fold defaultstate="collapsed" desc="matchOption">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 173,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 179,
 FQN = "matchOption", NM = "_ZL11matchOptionPKN4llvm3opt8OptTable4InfoENS_9StringRefEb",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL11matchOptionPKN4llvm3opt8OptTable4InfoENS_9StringRefEb")
//</editor-fold>
public static /*uint*/int matchOption(type$ptr<OptTable.Info> I, StringRef Str, boolean IgnoreCase) {
  for (/*const*/type$ptr<char$ptr>/*char P const P*/ Pre = $tryClone(I./*->*/$star().Prefixes); Pre.$star() != null; Pre.$preInc()) {
    StringRef Prefix/*J*/= new StringRef(Pre.$star());
    if (Str.startswith(Prefix)) {
      StringRef Rest = Str.substr(Prefix.size());
      boolean Matched = IgnoreCase ? Rest.startswith_lower(new StringRef(I./*->*/$star().Name)) : Rest.startswith(I./*->*/$star().Name);
      if (Matched) {
        return Prefix.size() + strlen(I./*->*/$star().Name);
      }
    }
  }
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="getOptionHelpName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 291,
 FQN="getOptionHelpName", NM="_ZL17getOptionHelpNameRKN4llvm3opt8OptTableENS0_12OptSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL17getOptionHelpNameRKN4llvm3opt8OptTableENS0_12OptSpecifierE")
//</editor-fold>
public static std.string getOptionHelpName(/*const*/ OptTable /*&*/ Opts, OptSpecifier Id) {
  /*const*/ Option O = Opts.getOption(/*NO_COPY*/Id);
  std.string Name = O.getPrefixedName();
  
  // Add metavar, if used.
  switch (O.getKind()) {
   case Option.OptionClass.GroupClass:
   case Option.OptionClass.InputClass:
   case Option.OptionClass.UnknownClass:
    throw new llvm_unreachable("Invalid option with help text.");
   case Option.OptionClass.MultiArgClass:
    {
      /*const*/char$ptr/*char P*/ MetaVarName = $tryClone(Opts.getOptionMetaVar(/*NO_COPY*/Id));
      if ((MetaVarName != null)) {
        // For MultiArgs, metavar is full list of all argument names.
        Name.$addassign($$SPACE);
        Name.$addassign(MetaVarName);
      } else {
        // For MultiArgs<N>, if metavar not supplied, print <value> N times.
        for (/*uint*/int i = 0, e = O.getNumArgs(); $less_uint(i, e); ++i) {
          Name.$addassign(/*KEEP_STR*/" <value>");
        }
      }
    }
    break;
   case Option.OptionClass.FlagClass:
    break;
   case Option.OptionClass.SeparateClass:
   case Option.OptionClass.JoinedOrSeparateClass:
   case Option.OptionClass.RemainingArgsClass:
   case Option.OptionClass.RemainingArgsJoinedClass:
    Name.$addassign($$SPACE);
   case Option.OptionClass.JoinedClass:
   case Option.OptionClass.CommaJoinedClass:
   case Option.OptionClass.JoinedAndSeparateClass:
    {
      // FALLTHROUGH
      /*const*/char$ptr/*char P*/ MetaVarName = $tryClone(Opts.getOptionMetaVar(/*NO_COPY*/Id));
      if ((MetaVarName != null)) {
        Name.$addassign(MetaVarName);
      } else {
        Name.$addassign(/*KEEP_STR*/"<value>");
      }
    }
    break;
  }
  
  return Name;
}

//<editor-fold defaultstate="collapsed" desc="PrintHelpOptionList">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 333,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 340,
 FQN = "PrintHelpOptionList", NM = "_ZL19PrintHelpOptionListRN4llvm11raw_ostreamENS_9StringRefERSt6vectorISt4pairISsPKcESaIS7_EE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL19PrintHelpOptionListRN4llvm11raw_ostreamENS_9StringRefERSt6vectorISt4pairISsPKcESaIS7_EE")
//</editor-fold>
public static void PrintHelpOptionList(raw_ostream /*&*/ OS, StringRef Title, std.vector<std.pair<std.string, /*const*/char$ptr/*char P*/ > > /*&*/ OptionHelp) {
  OS.$out(Title).$out(":\n");
  
  // Find the maximum option length.
  /*uint*/int OptionFieldWidth = 0;
  for (/*uint*/int i = 0, e = OptionHelp.size(); i != e; ++i) {
    // Skip titles.
    if (!(OptionHelp.$at(i).second != null)) {
      continue;
    }
    
    // Limit the amount of padding we are willing to give up for alignment.
    /*uint*/int Length = OptionHelp.$at(i).first.size();
    if (Length <= 23) {
      OptionFieldWidth = std.max(OptionFieldWidth, Length);
    }
  }
  
  /*const*//*uint*/int InitialPad = 2;
  for (/*uint*/int i = 0, e = OptionHelp.size(); i != e; ++i) {
    /*const*/std.string/*&*/ Option = OptionHelp.$at(i).first;
    /*uint*/int Pad = OptionFieldWidth - ((int)(Option.size()));
    OS.indent(InitialPad).$out(Option);
    
    // Break on long option names.
    if (Pad < 0) {
      OS.$out($LF);
      Pad = OptionFieldWidth + InitialPad;
    }
    OS.indent(Pad + 1).$out(OptionHelp.$at(i).second).$out_char($$LF);
  }
}

//<editor-fold defaultstate="collapsed" desc="getOptionHelpGroup">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 366,
 old_source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", old_line = 373,
 FQN = "getOptionHelpGroup", NM = "_ZL18getOptionHelpGroupRKN4llvm3opt8OptTableENS0_12OptSpecifierE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZL18getOptionHelpGroupRKN4llvm3opt8OptTableENS0_12OptSpecifierE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOptionHelpGroup(/*const*/OptTable /*&*/ Opts, OptSpecifier Id) {
  /*uint*/int GroupID = Opts.getOptionGroupID(Id);
  
  // If not in a group, return the default help group.
  if (!(GroupID != 0)) {
    return $("OPTIONS");
  }
  {
    
    // Abuse the help text of the option groups to store the "help group"
    // name.
    //
    // FIXME: Split out option groups.
    /*const*/char$ptr/*char P*/ GroupHelp = $tryClone(Opts.getOptionHelpText(new OptSpecifier(GroupID)));
    if ((GroupHelp != null)) {
      return GroupHelp;
    }
  }
  
  // Otherwise keep looking.
  return getOptionHelpGroup(Opts, new OptSpecifier(GroupID));
}

} // END OF class OptTableStatics
