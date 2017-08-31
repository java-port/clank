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
package org.llvm.cl;

import org.clank.java.*;
import static org.clank.java.built_in.__builtin_va_end;
import static org.clank.java.built_in.__builtin_va_start;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import static org.clank.support.Unsigned.$greater_uint;
import static org.clank.support.Unsigned.$less_uint;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.CommandLineStatics;
import org.llvm.support.sys.path;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;


//<editor-fold defaultstate="collapsed" desc="static type ClGlobals">
@Converted(kind = Converted.Kind.MANUAL,
 NM="org.llvm.cl.ClGlobals",
 cmd="jclank.sh -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -java-imports=${SPUTNIK}/contrib/JConvert/llvmToClankImports -print -package=org.llvm.cl -java-imports=${SPUTNIK}/modules/org.llvm.adtsupport/JavaImports ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -file-filter=${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#44;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#51;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#59;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#68;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#75;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#78;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#157;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#313;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#332;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#509;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#956;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#985;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1041;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1707;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1716;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1749;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1774;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1786;${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h#1802; -static-type=ClGlobals")
//</editor-fold>
public final class ClGlobals {


//===----------------------------------------------------------------------===//
// ParseCommandLineOptions - Command line option processing entry point.
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ParseCommandLineOptions">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9*/,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 992,
 FQN="llvm::cl::ParseCommandLineOptions", NM="_ZN4llvm2cl23ParseCommandLineOptionsEiPKPKcS2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl23ParseCommandLineOptionsEiPKPKcS2_b")
//</editor-fold>
public static boolean ParseCommandLineOptions(int argc, /*const*/char$ptr/*char P const P*/ argv[]) {
  return ParseCommandLineOptions(argc, create_type$ptr(argv), 
                       (/*const*/char$ptr/*char P*/ )null);
}
public static boolean ParseCommandLineOptions(int argc, /*const*/type$ptr<char$ptr>/*char P const P*/ argv) {
  return ParseCommandLineOptions(argc, argv, 
                       (/*const*/char$ptr/*char P*/ )null, false);
}
public static boolean ParseCommandLineOptions(int argc, /*const*/type$ptr<char$ptr>/*char P const P*/ argv, 
                       /*const*/char$ptr/*char P*/ Overview/*= null*/) {
  return ParseCommandLineOptions(argc, argv, 
          Overview, false);
}
public static boolean ParseCommandLineOptions(int argc, /*const*/type$ptr<char$ptr>/*char P const P*/ argv, 
                       /*const*/char$ptr/*char P*/ Overview/*= 0*/, boolean IgnoreErrors/* = false*/) {
  if (CommandLineStatics.USE_NEW_CL_PARSER) {
    return GlobalParser.$arrow().ParseCommandLineOptions(argc, argv, Overview, 
      IgnoreErrors);
  }
  SmallVector<Option /*P*//*, 4*/> PositionalOpts = null;
  SmallVector<Option /*P*//*, 4*/> SinkOpts = null;
  StringMap<Option /*P*//*, MallocAllocator*/> Opts = null;
  SmallVector</*const*/char$ptr/*char P*//*, 20*/> newArgv = null;
  // JAVA: StrDupSaver manually replaced with StringSaver and BumpPtrAllocatorImpl
  BumpPtrAllocatorImpl SaverAlloc = null;
  SmallVector<std.pairTypeUInt<StringRef>/*, 4*/> PositionalVals = null;
  try {
    // Process all registered options.
    PositionalOpts/*J*/= new SmallVector<Option /*P*//*, 4*/>(4, (Option /*P*/)null);
    SinkOpts/*J*/= new SmallVector<Option /*P*//*, 4*/>(4, (Option /*P*/)null);
    Opts/*J*/= new StringMap<Option /*P*//*, MallocAllocator*/>(null/*pointer*/);
    GetOptionInfo(PositionalOpts, SinkOpts, Opts);
    assert ((!Opts.empty() || !PositionalOpts.empty())) : "No options specified!";
    
    // Expand response files.
    newArgv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*, 20*/>(20, (char$ptr)null);
    for (int i = 0; i != argc; ++i)  {
      newArgv.push_back(argv.$at(i));
    }
    SaverAlloc = new BumpPtrAllocatorImpl();
    StringSaver Saver/*J*/= new StringSaver(SaverAlloc);
    ExpandResponseFiles(Saver, TokenizeGNUCommandLineCallback, newArgv);
    argv = $tryClone(newArgv.data());
    argc = (/*static_cast*/int)(newArgv.size());
    
    // Copy the program name into ProgName, making sure not to overflow it.
    std.string ProgName = path.filename(new StringRef(argv.$at(0))).$string();
    /*size_t*/int Len = std.min(ProgName.size(), ((/*size_t*/int)(79)));
    memcpy(ProgramName, ProgName.data(), Len);
    ProgramName.$set(Len, $('\0'));
    
    ProgramOverview = $tryClone(Overview);
    boolean ErrorParsing = false;
    
    // Check out the positional arguments to collect information about them.
    /*uint*/int NumPositionalRequired = 0;
    
    // Determine whether or not there are an unlimited number of positionals
    boolean HasUnlimitedPositionals = false;
    
    Option /*P*/ ConsumeAfterOpt = null;
    if (!PositionalOpts.empty()) {
      if (PositionalOpts.$at(0).getNumOccurrencesFlag() == NumOccurrencesFlag.ConsumeAfter) {
        assert (PositionalOpts.size() > 1) : "Cannot specify cl::ConsumeAfter without a positional argument!";
        ConsumeAfterOpt = PositionalOpts.$at(0);
      }
      
      // Calculate how many positional values are _required_.
      boolean UnboundedFound = false;
      for (/*size_t*/int i = ((ConsumeAfterOpt != null) ? 1 : 0), e = PositionalOpts.size();
           i != e; ++i) {
        Option /*P*/ Opt = PositionalOpts.$at(i);
        if (RequiresValue(Opt)) {
          ++NumPositionalRequired;
        } else if ((ConsumeAfterOpt != null)) {
          // ConsumeAfter cannot be combined with "optional" positional options
          // unless there is only one positional argument...
          if (PositionalOpts.size() > 2) {
            if (!IgnoreErrors) {
              Opt.error(new Twine(/*KEEP_STR*/"error - this positional option will never be matched, because it does not Require a value, and a cl::ConsumeAfter option is active!"));
            }
            ErrorParsing = true;
          }
        } else if (UnboundedFound && !Opt.hasArgStr()) {
          // This option does not "require" a value...  Make sure this option is
          // not specified after an option that eats all extra arguments, or this
          // one will never get any!
          //
          if (!IgnoreErrors) {
            Opt.error(new Twine(/*KEEP_STR*/"error - option can never match, because another positional argument will match an unbounded number of values, and this option does not require a value!"));
            errs().$out(ProgramName).$out(/*KEEP_STR*/": CommandLine Error: Option '").$out(
                /*NO_COPY*/Opt.ArgStr
            ).$out(/*KEEP_STR*/"' is all messed up!\n");
            errs().$out_uint(PositionalOpts.size());
          }
          ErrorParsing = true;
        }
        UnboundedFound |= EatsUnboundedNumberOfValues(Opt);
      }
      HasUnlimitedPositionals = UnboundedFound || (ConsumeAfterOpt != null);
    }
    
    // PositionalVals - A vector of "positional" arguments we accumulate into
    // the process at the end.
    //
    PositionalVals/*J*/= new SmallVector<std.pairTypeUInt<StringRef>/*, 4*/>(4, new std.pairTypeUInt(new StringRef(), 0));
    
    // If the program has named positional arguments, and the name has been run
    // across, keep track of which positional argument was named.  Otherwise put
    // the positional args into the PositionalVals list...
    Option /*P*/ ActivePositionalArg = null;
    
    // Loop over all of the arguments... processing them.
    boolean DashDashFound = false; // Have we read '--'?
    for (int i = 1; i < argc; ++i) {
      std.string NearestHandlerString = null;
      try {
        Option /*P*/ Handler = null;
        Option /*P*/ NearestHandler = null;
        NearestHandlerString/*J*/= new std.string();
        StringRef Value/*J*/= new StringRef();
        StringRef ArgName = new StringRef(NativePointer.$EMPTY);/*do not use StringRef.EMPTY here!*/
        
        // If the option list changed, this means that some command line
        // option has just been registered or deregistered.  This can occur in
        // response to things like -load, etc.  If this happens, rescan the options.
        if (OptionListChanged) {
          PositionalOpts.clear();
          SinkOpts.clear();
          Opts.clear();
          GetOptionInfo(PositionalOpts, SinkOpts, Opts);
          OptionListChanged = false;
        }
        
        // Check to see if this is a positional argument.  This argument is
        // considered to be positional if it doesn't start with '-', if it is "-"
        // itself, or if we have seen "--" already.
        //
        if (argv.$at(i).$at(0) != $('-') || argv.$at(i).$at(1) == 0 || DashDashFound) {
          // Positional argument!
          if ((ActivePositionalArg != null)) {
            ProvidePositionalOption(ActivePositionalArg, new StringRef(argv.$at(i)), i);
            continue; // We are done!
          }
          if (!PositionalOpts.empty()) {
            PositionalVals.push_back(std.make_pair_T_uint(new StringRef(argv.$at(i)), i));
            
            // All of the positional arguments have been fulfulled, give the rest to
            // the consume after option... if it's specified...
            //
            if (PositionalVals.size() >= NumPositionalRequired
               && ConsumeAfterOpt != null) {
              for (++i; i < argc; ++i)  {
                PositionalVals.push_back(std.make_pair_T_uint(new StringRef(argv.$at(i)), i));
              }
              break; // Handle outside of the argument processing loop...
            }
            
            // Delay processing positional arguments until the end...
            continue;
          }
        } else if (argv.$at(i).$at(0) == $('-') && argv.$at(i).$at(1) == $('-') && argv.$at(i).$at(2) == 0
           && !DashDashFound) {
          DashDashFound = true; // This is the mythical "--"?
          continue; // Don't try to process it as an argument itself.
        } else if ((ActivePositionalArg != null)
           && ((ActivePositionalArg.getMiscFlags() & MiscFlags.PositionalEatsArgs) != 0)) {
          // If there is a positional argument eating options, check to see if this
          // option is another positional argument.  If so, treat it as an argument,
          // otherwise feed it to the eating positional.
          ArgName.$assign(new StringRef(argv.$at(i).$add(1)));
          // Eat leading dashes.
          while (!ArgName.empty() && ArgName.$at(0) == $('-')) {
            ArgName.$assign$substr(1);
          }
          
          Handler = LookupOption(ArgName, Value, Opts);
          if (!(Handler != null) || Handler.getFormattingFlag() != FormattingFlags.Positional) {
            ProvidePositionalOption(ActivePositionalArg, new StringRef(argv.$at(i)), i);
            continue; // We are done!
          }
        } else { // We start with a '-', must be an argument.
          ArgName.$assign(new StringRef(argv.$at(i).$add(1)));
          // Eat leading dashes.
          while (!ArgName.empty() && ArgName.$at(0) == $('-')) {
            ArgName.$assign$substr(1);
          }
          
          Handler = LookupOption(ArgName, Value, Opts);
          
          // Check to see if this "option" is really a prefixed or grouped argument.
          if (Handler == null) {
            bool$ref ErrorParsingRef = create_bool$ref(ErrorParsing);
            Handler = HandlePrefixedOrGroupedOption(ArgName, Value, 
                ErrorParsingRef, Opts);
            ErrorParsing = ErrorParsingRef.$deref();
          }
          
          // Otherwise, look for the closest available option to report to the user
          // in the upcoming error.
          if (Handler == null && SinkOpts.empty()) {
            NearestHandler = LookupNearestOption(ArgName, Opts, 
                NearestHandlerString);
          }
        }
        if (Handler == null) {
          if (SinkOpts.empty()) {
            if (!IgnoreErrors) {
              errs().$out(ProgramName).$out(/*KEEP_STR*/": Unknown command line argument '").$out(
                  argv.$at(i)
              ).$out(/*KEEP_STR*/"'.  Try: '").$out(argv.$at(0)).$out(/*KEEP_STR*/" -help'\n");
              if ((NearestHandler != null)) {
                // If we know a near match, report it as well.
                errs().$out(ProgramName).$out(/*KEEP_STR*/": Did you mean '-").$out(NearestHandlerString).$out(
                    /*KEEP_STR*/"'?\n"
                );
              }
            }
            ErrorParsing = true;
          } else {
            for (type$ptr<Option /*P*/ > I = $tryClone(SinkOpts.begin()), 
                E = $tryClone(SinkOpts.end()); I.$noteq(E); I.$preInc())  {
              (I.$star()).addOccurrence(i, StringRef.R$EMPTY, new StringRef(argv.$at(i)));
            }
          }
          continue;
        }
        
        // If this is a named positional argument, just remember that it is the
        // active one...
        if (Handler.getFormattingFlag() == FormattingFlags.Positional) {
          ActivePositionalArg = Handler;
        } else {
          int$ref iRef = create_int$ref(i);
          ErrorParsing |= ProvideOption(Handler, ArgName, Value, argc, argv, iRef);
          i = iRef.$deref();
        }
      } finally {
        if (NearestHandlerString != null) { NearestHandlerString.$destroy(); }
      }
    }
    
    // Check and handle positional arguments now...
    if (NumPositionalRequired > PositionalVals.size()) {
      if (!IgnoreErrors) {
        errs().$out(ProgramName).$out(
            /*KEEP_STR*/": Not enough positional command line arguments specified!\n"
        ).$out(
            /*KEEP_STR*/"Must specify at least "
        ).$out_uint(NumPositionalRequired).$out(
            /*KEEP_STR*/" positional arguments: See: "
        ).$out(argv.$at(0)).$out(/*KEEP_STR*/" -help\n");
      }
      ErrorParsing = true;
    } else if (!HasUnlimitedPositionals
       && PositionalVals.size() > PositionalOpts.size()) {
      if (!IgnoreErrors) {
        errs().$out(ProgramName).$out(/*KEEP_STR*/": Too many positional arguments specified!\n").$out(
            /*KEEP_STR*/"Can specify at most "
        ).$out_uint(PositionalOpts.size()).$out(
            /*KEEP_STR*/" positional arguments: See: "
        ).$out(argv.$at(0)).$out(/*KEEP_STR*/" -help\n");
      }
      ErrorParsing = true;
    } else if (ConsumeAfterOpt == null) {
      // Positional args have already been handled if ConsumeAfter is specified.
      /*uint*/int ValNo = 0, NumVals = PositionalVals.size();
      for (/*size_t*/int i = 0, e = PositionalOpts.size(); i != e; ++i) {
        if (RequiresValue(PositionalOpts.$at(i))) {
          ProvidePositionalOption(PositionalOpts.$at(i), PositionalVals.$at(ValNo).first, 
              PositionalVals.$at(ValNo).second);
          ValNo++;
          --NumPositionalRequired; // We fulfilled our duty...
        }
        
        // If we _can_ give this option more arguments, do so now, as long as we
        // do not give it values that others need.  'Done' controls whether the
        // option even _WANTS_ any more.
        //
        boolean Done = PositionalOpts.$at(i).getNumOccurrencesFlag() == NumOccurrencesFlag.Required;
        while (NumVals - ValNo > NumPositionalRequired && !Done) {
          switch (PositionalOpts.$at(i).getNumOccurrencesFlag()) {
           case Optional:
            Done = true; // Optional arguments want _at most_ one value
            // FALL THROUGH
           case ZeroOrMore: // Zero or more will take all they can get...
           case OneOrMore: // One or more will take all they can get...
            ProvidePositionalOption(PositionalOpts.$at(i), 
                PositionalVals.$at(ValNo).first, 
                PositionalVals.$at(ValNo).second);
            ValNo++;
            break;
           default:
            throw new llvm_unreachable("Internal error, unexpected NumOccurrences flag in positional argument processing!");
          }
        }
      }
    } else {
      assert ((ConsumeAfterOpt != null) && NumPositionalRequired <= PositionalVals.size());
      /*uint*/int ValNo = 0;
      for (/*size_t*/int j = 1, e = PositionalOpts.size(); j != e; ++j)  {
        if (RequiresValue(PositionalOpts.$at(j))) {
          ErrorParsing |= ProvidePositionalOption(PositionalOpts.$at(j), 
              PositionalVals.$at(ValNo).first, 
              PositionalVals.$at(ValNo).second);
          ValNo++;
        }
      }
      
      // Handle the case where there is just one positional option, and it's
      // optional.  In this case, we want to give JUST THE FIRST option to the
      // positional option and keep the rest for the consume after.  The above
      // loop would have assigned no values to positional options in this case.
      //
      if (PositionalOpts.size() == 2 && ValNo == 0 && !PositionalVals.empty()) {
        ErrorParsing |= ProvidePositionalOption(PositionalOpts.$at(1), 
            PositionalVals.$at(ValNo).first, 
            PositionalVals.$at(ValNo).second);
        ValNo++;
      }
      
      // Handle over all of the rest of the arguments to the
      // cl::ConsumeAfter command line option...
      for (; ValNo != PositionalVals.size(); ++ValNo)  {
        ErrorParsing |= ProvidePositionalOption(ConsumeAfterOpt, 
            PositionalVals.$at(ValNo).first, 
            PositionalVals.$at(ValNo).second);
      }
    }
    
    // Loop over args and make sure all required args are specified!
    for (StringMapIterator<Option /*P*/ > I = $tryClone(Opts.begin()), 
        E = $tryClone(Opts.end()); I.$noteq(E); I.$preInc()) {
      switch (I.$arrow().second.getNumOccurrencesFlag()) {
       case Required:
       case OneOrMore:
        if (I.$arrow().second.getNumOccurrences() == 0) {
          I.$arrow().second.error(new Twine("must be specified at least once!"));
          ErrorParsing = true;
        }
       default:
        // Fall through
        break;
      }
    }
    
    // Now that we know if -debug is specified, we can use it.
    // Note that if ReadResponseFiles == true, this must be done before the
    // memory allocated for the expanded command line is free()d below.
    do {
      if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
        dbgs().$out("Args: ");
        for (int i = 0; i < argc; ++i)  {
          dbgs().$out(argv.$at(i)).$out_char($$SPACE);
        }
        dbgs().$out_char($$LF);
        ;
      }
    } while (false);
    
    // Free all of the memory allocated to the map.  Command line options may only
    // be processed once!
    Opts.clear();
    PositionalOpts.clear();
    MoreHelp.$arrow().clear();
    
    // If we had an error processing our arguments, don't let the program execute
    if (ErrorParsing) {
      if (!IgnoreErrors) {
        exit(1);
      }
      return false;
    }
  } finally {
    if (PositionalVals != null) { PositionalVals.$destroy(); }
    if (SaverAlloc != null) { SaverAlloc.$destroy(); }
    if (newArgv != null) { newArgv.$destroy(); }
    if (Opts != null) { Opts.$destroy(); }
    if (SinkOpts != null) { SinkOpts.$destroy(); }
    if (PositionalOpts != null) { PositionalOpts.$destroy(); }
  }
  return true;
}


//===----------------------------------------------------------------------===//
// ParseEnvironmentOptions - Environment variable option processing alternate
//                           entry point.
//

/// ParseEnvironmentOptions - An alternative entry point to the
/// CommandLine library, which allows you to read the program's name
/// from the caller (as PROGNAME) and its command-line arguments from
/// an environment variable (whose name is given in ENVVAR).
///
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ParseEnvironmentOptions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 948,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 783,
 FQN="llvm::cl::ParseEnvironmentOptions", NM="_ZN4llvm2cl23ParseEnvironmentOptionsEPKcS2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl23ParseEnvironmentOptionsEPKcS2_S2_")
//</editor-fold>
public static void ParseEnvironmentOptions(/*const*/char$ptr/*char P*/ progName, /*const*/char$ptr/*char P*/ envVar) {
  ParseEnvironmentOptions(progName, envVar, 
                       (/*const*/char$ptr/*char P*/ )null);
}
public static void ParseEnvironmentOptions(/*const*/char$ptr/*char P*/ progName, /*const*/char$ptr/*char P*/ envVar, 
                       /*const*/char$ptr/*char P*/ Overview/*= null*/) {
  BumpPtrAllocatorImpl A = null;
  try {
    // Check args.
    assert (Native.$bool(progName)) : "Program name not specified";
    assert (Native.$bool(envVar)) : "Environment variable name missing";
    /*const*/char$ptr/*char P*/ envValue = $tryClone(getenv(envVar));
    if (!Native.$bool(envValue)) {
      return;
    }
    
    // Get program's "name", which we wouldn't know without the caller
    // telling us.
    SmallVector</*const*/char$ptr/*char P*//*,  20*/> newArgv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  20*/>(20, null);
    A/*J*/= new BumpPtrAllocatorImpl();
    StringSaver Saver/*J*/= new StringSaver(A);
    newArgv.push_back(Saver.save(progName));
    
    // Parse the value of the environment variable into a "command line"
    // and hand it off to ParseCommandLineOptions().
    TokenizeGNUCommandLine(new StringRef(envValue), Saver, newArgv);
    int newArgc = ((/*static_cast*/int)(newArgv.size()));
    ParseCommandLineOptions(newArgc, newArgv.data(), Overview);
  } finally {
    if (A != null) { A.$destroy(); }
  }
}


///===---------------------------------------------------------------------===//
/// SetVersionPrinter - Override the default (LLVM specific) version printer
///                     used to print out the version when --version is given
///                     on the command line. This allows other systems using the
///                     CommandLine utilities to print their own version string.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::SetVersionPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2109,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1819,
 FQN="llvm::cl::SetVersionPrinter", NM="_ZN4llvm2cl17SetVersionPrinterEPFvvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl17SetVersionPrinterEPFvvE")
//</editor-fold>
public static void SetVersionPrinter(Void2Void func) {
  OverrideVersionPrinter = $tryClone(func);
}


///===---------------------------------------------------------------------===//
/// AddExtraVersionPrinter - Add an extra printer to use in addition to the
///                          default one. This can be called multiple times,
///                          and each time it adds a new function to the list
///                          which will be called after the basic LLVM version
///                          printing is complete. Each can then add additional
///                          information specific to the tool.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::AddExtraVersionPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2111,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1821,
 FQN="llvm::cl::AddExtraVersionPrinter", NM="_ZN4llvm2cl22AddExtraVersionPrinterEPFvvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl22AddExtraVersionPrinterEPFvvE")
//</editor-fold>
public static void AddExtraVersionPrinter(Void2Void func) {
  if (!(ExtraVersionPrinters != null)) {
    ExtraVersionPrinters = new std.vector<Void2Void>((Void2Void)null);
  }
  
  ExtraVersionPrinters.push_back_T$C$R(func);
}


// PrintOptionValues - Print option values.
// With -print-options print the difference between option values and defaults.
// With -print-all-options print all option values.
// (Currently not perfect, but best-effort.)

// Print the value of each option.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::PrintOptionValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2002,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1713,
 FQN="llvm::cl::PrintOptionValues", NM="_ZN4llvm2cl17PrintOptionValuesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl17PrintOptionValuesEv")
//</editor-fold>
public static void PrintOptionValues() {
  GlobalParser.$arrow().printOptionValues();
}


/// \brief Adds a new option for parsing and provides the option it refers to.
///
/// \param O pointer to the option
/// \param Name the string name for the option to handle during parsing
///
/// Literal options are used by some parsers to register special option values.
/// This is how the PassNameParser registers pass names for opt.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::AddLiteralOption">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 338,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 215,
 FQN="llvm::cl::AddLiteralOption", NM="_ZN4llvm2cl16AddLiteralOptionERNS0_6OptionEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl16AddLiteralOptionERNS0_6OptionEPKc")
//</editor-fold>
public static void AddLiteralOption(final Option /*&*/ O, /*const*/char$ptr/*char P*/ Name) {
  GlobalParser.$arrow().addLiteralOption(O, Name);
}

/*template <class Ty> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::init">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 379,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 324,
 FQN="llvm::cl::init", NM="Tpl__ZN4llvm2cl4initERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl4initERKT_")
//</editor-fold>
public static </*class*/ Ty> initializer<Ty> init(final /*const*/ Ty /*&*/ Val) {
  return new initializer<>(Val);
}

/*template <class Ty> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::location">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 394,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 339,
 FQN="llvm::cl::location", NM="Tpl__ZN4llvm2cl8locationERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl8locationERT_")
//</editor-fold>
public static </*class*/ Ty> LocationClass<Ty> location(final type$ref<Ty> /*&*/ L) {
  return new LocationClass(L);
}

@Converted(kind = Converted.Kind.MANUAL) // how to add this to extra members???
public static LocationClass<Boolean> location(final bool$ref /*&*/ L) {
  type$ref<Boolean> wrapper = new type$ref<Boolean>() {
    @Override
    public Boolean $deref() {
      return L.$deref();
    }

    @Override
    public Boolean $set(Boolean value) {
      L.$set(value);
      return L.$deref();
    }
  };
  return new LocationClass<Boolean>(wrapper);
}
public static LocationClass<Boolean> location$Bool(final bool$ref /*&*/ L) {
  throw new UnsupportedOperationException();
}

public static LocationClass<std.string> location(final std.string /*&*/ L) {
  type$ref<std.string> ref = new type$ptr$inout<std.string>(L) {
    @Override
    protected std.string $star$impl() {
      return L;
    }

    @Override
    protected std.string $set$impl(string value) {
      return L.$assign(value);
    }
  };
  return new LocationClass<std.string>(ref);
}

/*template <class DataType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::values">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*char$ptr=>type$ptr for builtin_va-funcs*/,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 597,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 533,
 FQN="llvm::cl::values", NM="Tpl__ZN4llvm2cl6valuesEPKcT_S2_z",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl6valuesEPKcT_S2_z")
//</editor-fold>
public static </*class*/ DataType> ValuesClass<DataType> values(/*const*/char$ptr/*char P*/ Arg, DataType Val, /*const*/char$ptr/*char P*/ Desc, Object ... $VarArg)/* __attribute__((sentinel(0, 0)))*/ {
  type$ptr/*char P*/ ValueArgs = create_type$ptr();
  __builtin_va_start($VarArg, ValueArgs, Desc);
  ValuesClass<DataType> Vals/*J*/= /*ParenList*/new ValuesClass<DataType>(Arg, Val, Desc, ValueArgs);
  __builtin_va_end(ValueArgs);
  return Vals;
}


//--------------------------------------------------
// PrintOptionDiff
//
// This collection of wrappers is the intermediary between class opt and class
// parser to handle all the template nastiness.

// This overloaded function is selected by the generic parser.
/*template <class ParserClass, class DT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::printOptionDiff">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1054,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 990,
 FQN="llvm::cl::printOptionDiff", NM="Tpl__ZN4llvm2cl15printOptionDiffERKNS0_6OptionERKNS0_19generic_parser_baseERKT0_RKNS0_11OptionValueIS7_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl15printOptionDiffERKNS0_6OptionERKNS0_19generic_parser_baseERKT0_RKNS0_11OptionValueIS7_EEj")
//</editor-fold>
public static </*class*/ ParserClass, /*class*/ DT> void printOptionDiff(/*const*/ Option /*&*/ O, /*const*/ generic_parser_base /*&*/ P, /*const*/ DT /*&*/ V, 
               /*const*/ OptionValue<DT> /*&*/ Default, /*size_t*/int GlobalWidth) {
  throw new UnsupportedOperationException("EmptyBody");
}


// This overloaded function is selected by the basic parser, which may parse a
// different type than the option type.
/*template <class ParserClass, class ValDT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::printOptionDiff">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1081,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1017,
 FQN="llvm::cl::printOptionDiff", NM="Tpl__ZN4llvm2cl15printOptionDiffERKNS0_6OptionERKNS0_12basic_parserINT_16parser_data_typeEEERKT0_RKNS0_11OptionValueISA_EEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl15printOptionDiffERKNS0_6OptionERKNS0_12basic_parserINT_16parser_data_typeEEERKT0_RKNS0_11OptionValueISA_EEj")
//</editor-fold>
public static </*class*/ ParserClassDataType, /*class*/ ValDT> void printOptionDiff(/*const*/ Option /*&*/ O, 
               /*const*/ basic_parser< ParserClassDataType> /*&*/ P, 
               /*const*/ ValDT /*&*/ V, /*const*/ OptionValue<ValDT> /*&*/ Default, 
               /*size_t*/int GlobalWidth) {
  throw new UnsupportedOperationException("EmptyBody");
}


// apply method - Apply modifiers to an option in a type safe way.
/*template <class Opt, class Mod, class ... Mods> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::apply">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1138,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1074,
 FQN="llvm::cl::apply", NM="Tpl__ZN4llvm2cl5applyEPT_RKT0_DpRKT1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl5applyEPT_RKT0_DpRKT1_")
//</editor-fold>
public static </*class*/ Opt, /*class*/ Mod, /*class*/ /*...*/ Mods> void apply(Opt /*P*/ O, final /*const*/ Mod /*&*/ M, /*const*/ Mods /*&*/ ...Ms) {
  throw new UnsupportedOperationException("EmptyBody");
}

/*template <class Opt, class Mod> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cl::apply">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1143,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1080,
 FQN="llvm::cl::apply", NM="Tpl__ZN4llvm2cl5applyEPT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl5applyEPT_RKT0_")
//</editor-fold>
public static </*class*/ Opt, /*class*/ Mod> void apply(Opt /*P*/ O, final /*const*/ Mod /*&*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Utility function for printing version number.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::PrintVersionMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2107,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1817,
 FQN="llvm::cl::PrintVersionMessage", NM="_ZN4llvm2cl19PrintVersionMessageEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19PrintVersionMessageEv")
//</editor-fold>
public static void PrintVersionMessage() {
  VersionPrinterInstance.print();
}


/// This function just prints the help message, exactly the same way as if the
/// -help or -help-hidden option had been given on the command line.
///
/// NOTE: THIS FUNCTION TERMINATES THE PROGRAM!
///
/// \param Hidden if true will print hidden options
/// \param Categorized if true print options in categories

// Utility function for printing the help message.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::PrintHelpMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2088,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1798,
 FQN="llvm::cl::PrintHelpMessage", NM="_ZN4llvm2cl16PrintHelpMessageEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl16PrintHelpMessageEbb")
//</editor-fold>
public static void PrintHelpMessage() {
  PrintHelpMessage(false, false);
}
public static void PrintHelpMessage(boolean Hidden/*= false*/) {
  PrintHelpMessage(Hidden, false);
}
public static void PrintHelpMessage(boolean Hidden/*= false*/, boolean Categorized/*= false*/) {
  // This looks weird, but it actually prints the help message. The Printers are
  // types of HelpPrinter and the help gets printed when its operator= is
  // invoked. That's because the "normal" usages of the help printer is to be
  // assigned true/false depending on whether -help or -help-hidden was given or
  // not.  Since we're circumventing that we have to make it look like -help or
  // -help-hidden were given, so we assign true.
  if (!Hidden && !Categorized) {
    UncategorizedNormalPrinter.$assign(/*KEEP_BOOL*/true);
  } else if (!Hidden && Categorized) {
    CategorizedNormalPrinter.$assign(/*KEEP_BOOL*/true);
  } else if (Hidden && !Categorized) {
    UncategorizedHiddenPrinter.$assign(/*KEEP_BOOL*/true);
  } else {
    CategorizedHiddenPrinter.$assign(/*KEEP_BOOL*/true);
  }
}


//===----------------------------------------------------------------------===//
// Public interface for accessing registered options.
//

/// \brief Use this to get a StringMap to all registered named options
/// (e.g. -help). Note \p Map Should be an empty StringMap.
///
/// \return A reference to the StringMap used by the cl APIs to parse options.
///
/// Access to unnamed arguments (i.e. positional) are not provided because
/// it is expected that the client already has access to these.
///
/// Typical usage:
/// \code
/// main(int argc,char* argv[]) {
/// StringMap<llvm::cl::Option*> &opts = llvm::cl::getRegisteredOptions();
/// assert(opts.count("help") == 1)
/// opts["help"]->setDescription("Show alphabetical help information")
/// // More code
/// llvm::cl::ParseCommandLineOptions(argc,argv);
/// //More code
/// }
/// \endcode
///
/// This interface is useful for modifying options in libraries that are out of
/// the control of the client. The options should be modified before calling
/// llvm::cl::ParseCommandLineOptions().
///
/// Hopefully this API can be depricated soon. Any situation where options need
/// to be modified by tools or libraries should be handled by sane APIs rather
/// than just handing around a global list.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::getRegisteredOptions">
@Converted(kind = Converted.Kind.MANUAL/*pre-3.9*/,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2118,
 FQN="llvm::cl::getRegisteredOptions", NM="_ZN4llvm2cl20getRegisteredOptionsERNS0_10SubCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl20getRegisteredOptionsERNS0_10SubCommandE")
//</editor-fold>
public static StringMap<Option /*P*/> getRegisteredOptions(SubCommand sub) {
  return getRegisteredOptions(sub.OptionsMap);
}
public static StringMap<Option /*P*/> getRegisteredOptions(StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ Map) {
  SmallVector<Option /*P*//*, 4*/> PositionalOpts = null;
  SmallVector<Option /*P*//*, 4*/> SinkOpts = null;
  try {
    // Get all the options.
    PositionalOpts/*J*/= new SmallVector<Option /*P*//*, 4*/>(4, (Option /*P*/)null); //NOT USED
    SinkOpts/*J*/= new SmallVector<Option /*P*//*, 4*/>(4, (Option /*P*/)null); //NOT USED
    assert (Map.size() == 0) : "StringMap must be empty. Probably should be different when upgrade to 3.9";
    GetOptionInfo(PositionalOpts, SinkOpts, Map);
    return Map;
  } finally {
    if (SinkOpts != null) { SinkOpts.$destroy(); }
    if (PositionalOpts != null) { PositionalOpts.$destroy(); }
  }
}


//===----------------------------------------------------------------------===//
// Standalone command line processing utilities.
//

/// \brief Tokenizes a command line that can contain escapes and quotes.
//
/// The quoting rules match those used by GCC and other tools that use
/// libiberty's buildargv() or expandargv() utilities, and do not match bash.
/// They differ from buildargv() on treatment of backslashes that do not escape
/// a special character to make it possible to accept most Windows file paths.
///
/// \param [in] Source The string to be split on whitespace with quotes.
/// \param [in] Saver Delegates back to the caller for saving parsed strings.
/// \param [in] MarkEOLs true if tokenizing a response file and you want end of
/// lines and end of the response file to be marked with a nullptr string.
/// \param [out] NewArgv All parsed strings are appended to NewArgv.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::TokenizeGNUCommandLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 686,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 520,
 FQN="llvm::cl::TokenizeGNUCommandLine", NM="_ZN4llvm2cl22TokenizeGNUCommandLineENS_9StringRefERNS_11StringSaverERNS_15SmallVectorImplIPKcEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl22TokenizeGNUCommandLineENS_9StringRefERNS_11StringSaverERNS_15SmallVectorImplIPKcEEb")
//</editor-fold>
public static void TokenizeGNUCommandLine(StringRef Src, final StringSaver /*&*/ Saver, 
                      final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv) {
  TokenizeGNUCommandLine(Src, Saver, 
                      NewArgv, 
                      false);
}
public static void TokenizeGNUCommandLine(StringRef Src, final StringSaver /*&*/ Saver, 
                      final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv, 
                      boolean MarkEOLs/*= false*/) {
  SmallString/*128*/ Token/*J*/= new SmallString/*128*/(128);
  for (/*size_t*/int I = 0, E = Src.size(); I != E; ++I) {
    // Consume runs of whitespace.
    if (Token.empty()) {
      while (I != E && isWhitespace(Src.$at(I))) {
        // Mark the end of lines in response files
        if (MarkEOLs && Src.$at(I) == $$LF) {
          NewArgv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
        }
        ++I;
      }
      if (I == E) {
        break;
      }
    }
    
    // Backslash escapes the next character.
    if ($less_uint(I + 1, E) && Src.$at(I) == $$BACK_SLASH) {
      ++I; // Skip the escape.
      Token.push_back(Src.$at(I));
      continue;
    }
    
    // Consume a quoted string.
    if (isQuote(Src.$at(I))) {
      /*char*/byte Quote = Src.$at(I++);
      while (I != E && Src.$at(I) != Quote) {
        // Backslash escapes the next character.
        if (Src.$at(I) == $$BACK_SLASH && I + 1 != E) {
          ++I;
        }
        Token.push_back(Src.$at(I));
        ++I;
      }
      if (I == E) {
        break;
      }
      continue;
    }
    
    // End the token if this is whitespace.
    if (isWhitespace(Src.$at(I))) {
      if (!Token.empty()) {
        NewArgv.push_back(Saver.save(Token.c_str()));
      }
      Token.clear();
      continue;
    }
    
    // This is a normal character.  Append it.
    Token.push_back(Src.$at(I));
  }
  
  // Append the last token after hitting EOF with no whitespace.
  if (!Token.empty()) {
    NewArgv.push_back(Saver.save(Token.c_str()));
  }
  // Mark the end of response files
  if (MarkEOLs) {
    NewArgv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
  }
}

// This is a small state machine to consume characters until it reaches the
// end of the source string.
//<editor-fold defaultstate="collapsed" desc="">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 548)
//</editor-fold>
private static enum Unnamed_enum {
  INIT(0),
  UNQUOTED(1),
  QUOTED(2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Unnamed_enum valueOf(int val) {
    Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final Unnamed_enum[] VALUES;
    private static final Unnamed_enum[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Unnamed_enum kind : Unnamed_enum.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
      VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
      for (Unnamed_enum kind : Unnamed_enum.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private Unnamed_enum(/*uint*/int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
};
  
/// \brief Tokenizes a Windows command line which may contain quotes and escaped
/// quotes.
///
/// See MSDN docs for CommandLineToArgvW for information on the quoting rules.
/// http://msdn.microsoft.com/en-us/library/windows/desktop/17w5ykft(v=vs.85).aspx
///
/// \param [in] Source The string to be split on whitespace with quotes.
/// \param [in] Saver Delegates back to the caller for saving parsed strings.
/// \param [in] MarkEOLs true if tokenizing a response file and you want end of
/// lines and end of the response file to be marked with a nullptr string.
/// \param [out] NewArgv All parsed strings are appended to NewArgv.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::TokenizeWindowsCommandLine">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 783,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 618,
 FQN="llvm::cl::TokenizeWindowsCommandLine", NM="_ZN4llvm2cl26TokenizeWindowsCommandLineENS_9StringRefERNS_11StringSaverERNS_15SmallVectorImplIPKcEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl26TokenizeWindowsCommandLineENS_9StringRefERNS_11StringSaverERNS_15SmallVectorImplIPKcEEb")
//</editor-fold>
public static void TokenizeWindowsCommandLine(StringRef Src, final StringSaver /*&*/ Saver, 
                          final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv) {
  TokenizeWindowsCommandLine(Src, Saver, 
                          NewArgv, 
                          false);
}
public static void TokenizeWindowsCommandLine(StringRef Src, final StringSaver /*&*/ Saver, 
                          final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv, 
                          boolean MarkEOLs/*= false*/) {
  SmallString/*128*/ Token/*J*/= new SmallString/*128*/(128);
  
  // This is a small state machine to consume characters until it reaches the
  // end of the source string.
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int INIT = 0;
    final /*uint*/int UNQUOTED = INIT + 1;
    final /*uint*/int QUOTED = UNQUOTED + 1;
  /*}*//*Unnamed enum*//*uint*/int State = INIT;
  for (/*size_t*/int I = 0, E = Src.size(); I != E; ++I) {
    // INIT state indicates that the current input index is at the start of
    // the string or between tokens.
    if (State == INIT) {
      if (isWhitespace(Src.$at(I))) {
        // Mark the end of lines in response files
        if (MarkEOLs && Src.$at(I) == $$LF) {
          NewArgv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
        }
        continue;
      }
      if (Src.$at(I) == $$DBL_QUOTE) {
        State = QUOTED;
        continue;
      }
      if (Src.$at(I) == $$BACK_SLASH) {
        I = parseBackslash(new StringRef(Src), I, Token);
        State = UNQUOTED;
        continue;
      }
      Token.push_back(Src.$at(I));
      State = UNQUOTED;
      continue;
    }
    
    // UNQUOTED state means that it's reading a token not quoted by double
    // quotes.
    if (State == UNQUOTED) {
      // Whitespace means the end of the token.
      if (isWhitespace(Src.$at(I))) {
        NewArgv.push_back(Saver.save(Token.c_str()));
        Token.clear();
        State = INIT;
        // Mark the end of lines in response files
        if (MarkEOLs && Src.$at(I) == $$LF) {
          NewArgv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
        }
        continue;
      }
      if (Src.$at(I) == $$DBL_QUOTE) {
        State = QUOTED;
        continue;
      }
      if (Src.$at(I) == $$BACK_SLASH) {
        I = parseBackslash(new StringRef(Src), I, Token);
        continue;
      }
      Token.push_back(Src.$at(I));
      continue;
    }
    
    // QUOTED state means that it's reading a token quoted by double quotes.
    if (State == QUOTED) {
      if (Src.$at(I) == $$DBL_QUOTE) {
        State = UNQUOTED;
        continue;
      }
      if (Src.$at(I) == $$BACK_SLASH) {
        I = parseBackslash(new StringRef(Src), I, Token);
        continue;
      }
      Token.push_back(Src.$at(I));
    }
  }
  // Append the last token after hitting EOF with no whitespace.
  if (!Token.empty()) {
    NewArgv.push_back(Saver.save(Token.c_str()));
  }
  // Mark the end of response files
  if (MarkEOLs) {
    NewArgv.push_back((/*const*/char$ptr/*char P*//*const*/)null);
  }
}

/// \brief String tokenization function type.  Should be compatible with either
/// Windows or Unix command line tokenizers.
//typedef void (*TokenizerCallback)(StringRef Source, StringSaver &Saver,
//                                  SmallVectorImpl<const char *> &NewArgv,
//                                  bool MarkEOLs);
@FunctionalInterface
public static interface TokenizerCallback {
  void $call(StringRef Source, StringSaver /*&*/ Saver, SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv, boolean MarkEOLs);
}

public static final TokenizerCallback TokenizeGNUCommandLineCallback = new TokenizerCallback() {
  @Override
  public void $call(StringRef Source, StringSaver Saver, SmallVectorImpl<char$ptr> NewArgv, boolean MarkEOLs) {
    TokenizeGNUCommandLine(Source, Saver, NewArgv);
  }
};

public static final TokenizerCallback TokenizeWindowsCommandLineCallback = new TokenizerCallback() {
  @Override
  public void $call(StringRef Source, StringSaver Saver, SmallVectorImpl<char$ptr> NewArgv, boolean MarkEOLs) {
    TokenizeWindowsCommandLine(Source, Saver, NewArgv);
  }
};

/// \brief Expand response files on a command line recursively using the given
/// StringSaver and tokenization strategy.  Argv should contain the command line
/// before expansion and will be modified in place. If requested, Argv will
/// also be populated with nullptrs indicating where each response file line
/// ends, which is useful for the "/link" argument that needs to consume all
/// remaining arguments only until the next end of line, when in a response
/// file.
///
/// \param [in] Saver Delegates back to the caller for saving parsed strings.
/// \param [in] Tokenizer Tokenization strategy. Typically Unix or Windows.
/// \param [in,out] Argv Command line into which to expand response files.
/// \param [in] MarkEOLs Mark end of lines and the end of the response file
/// with nullptrs in the Argv vector.
/// \return true if all @files were expanded successfully or there were none.

/// \brief Expand response files on a command line recursively using the given
/// StringSaver and tokenization strategy.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ExpandResponseFiles">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 900,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 735,
 FQN="llvm::cl::ExpandResponseFiles", NM="_ZN4llvm2cl19ExpandResponseFilesERNS_11StringSaverEPFvNS_9StringRefES2_RNS_15SmallVectorImplIPKcEEbES8_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19ExpandResponseFilesERNS_11StringSaverEPFvNS_9StringRefES2_RNS_15SmallVectorImplIPKcEEbES8_b")
//</editor-fold>
public static boolean ExpandResponseFiles(final StringSaver /*&*/ Saver, TokenizerCallback Tokenizer, 
                   final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Argv) {
  return ExpandResponseFiles(Saver, Tokenizer, 
                   Argv, 
                   false);
}
public static boolean ExpandResponseFiles(final StringSaver /*&*/ Saver, TokenizerCallback Tokenizer, 
                   final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Argv, 
                   boolean MarkEOLs/*= false*/) {
  /*uint*/int RspFiles = 0;
  boolean AllExpanded = true;
  
  // Don't cache Argv.size() because it can change.
  for (/*uint*/int I = 0; I != Argv.size();) {
      /*const*/char$ptr/*char P*/ Arg = $tryClone(Argv.$at(I));
      // Check if it is an EOL marker
    if (Arg == null) {
      ++I;
      continue;
    }
    if (Arg.$at(0) != $$AT) {
      ++I;
      continue;
    }

    // If we have too many response files, leave some unexpanded.  This avoids
    // crashing on self-referential response files.
    if ($greater_uint(RspFiles++, 20)) {
      return false;
    }

    // Replace this response file argument with the tokenization of its
    // contents.  Nested response files are expanded in subsequent iterations.
    // FIXME: If a nested response file uses a relative path, is it relative to
    // the cwd of the process or the response file?
    SmallVector</*const*/char$ptr/*char P*//*,  0*/> ExpandedArgv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  0*/>(0, null);
    if (!ExpandResponseFile(Arg.$add(1), Saver, Tokenizer, ExpandedArgv, 
        MarkEOLs)) {
      // We couldn't read this file, so we leave it in the argument stream and
      // move on.
      AllExpanded = false;
      ++I;
      continue;
    }
    Argv.erase(Argv.begin().$add(I));
    Argv.insert_iterator$T$value_T(Argv.begin().$add(I), ExpandedArgv.begin(), ExpandedArgv.end());
  }
  return AllExpanded;
}


/// \brief Mark all options not part of this category as cl::ReallyHidden.
///
/// \param Category the category of options to keep displaying
///
/// Some tools (like clang-format) like to be able to hide all options that are
/// not specific to the tool. This function allows a tool to specify a single
/// option category to display in the -help output.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::HideUnrelatedOptions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2125,
 FQN="llvm::cl::HideUnrelatedOptions", NM="_ZN4llvm2cl20HideUnrelatedOptionsERNS0_14OptionCategoryERNS0_10SubCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl20HideUnrelatedOptionsERNS0_14OptionCategoryERNS0_10SubCommandE")
//</editor-fold>
public static void HideUnrelatedOptions(final OptionCategory /*&*/ Category) {
  HideUnrelatedOptions(Category, TopLevelSubCommand.$star());
}
public static void HideUnrelatedOptions(final OptionCategory /*&*/ Category, final SubCommand /*&*/ Sub/*= * TopLevelSubCommand*/) {
  for (final StringMapEntry<Option /*P*/ > /*&*/ I : Sub.OptionsMap) {
    if (I.second.Category != $AddrOf(Category)
       && I.second.Category != $AddrOf(GenericCategory)) {
      I.second.setHiddenFlag(OptionHidden.ReallyHidden);
    }
  }
}


/// \brief Mark all options not part of the categories as cl::ReallyHidden.
///
/// \param Categories the categories of options to keep displaying.
///
/// Some tools (like clang-format) like to be able to hide all options that are
/// not specific to the tool. This function allows a tool to specify a single
/// option category to display in the -help output.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::HideUnrelatedOptions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2133,
 FQN="llvm::cl::HideUnrelatedOptions", NM="_ZN4llvm2cl20HideUnrelatedOptionsENS_8ArrayRefIPKNS0_14OptionCategoryEEERNS0_10SubCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl20HideUnrelatedOptionsENS_8ArrayRefIPKNS0_14OptionCategoryEEERNS0_10SubCommandE")
//</editor-fold>
public static void HideUnrelatedOptions(ArrayRef</*const*/ OptionCategory /*P*/ > Categories) {
  HideUnrelatedOptions(Categories, 
                    TopLevelSubCommand.$star());
}
public static void HideUnrelatedOptions(ArrayRef</*const*/ OptionCategory /*P*/ > Categories, 
                    final SubCommand /*&*/ Sub/*= * TopLevelSubCommand*/) {
  type$ptr</*const*/ OptionCategory /*P*/ /*const*/ /*P*/> CategoriesBegin = $tryClone(Categories.begin());
  type$ptr</*const*/ OptionCategory /*P*/ /*const*/ /*P*/> CategoriesEnd = $tryClone(Categories.end());
  for (final StringMapEntry<Option /*P*/ > /*&*/ I : Sub.OptionsMap) {
    if ($eq_ptr(std.find(CategoriesBegin, CategoriesEnd, I.second.Category), CategoriesEnd)
       && I.second.Category != $AddrOf(GenericCategory)) {
      I.second.setHiddenFlag(OptionHidden.ReallyHidden);
    }
  }
}


/// \brief Reset all command line options to a state that looks as if they have
/// never appeared on the command line.  This is useful for being able to parse
/// a command line multiple times (especially useful for writing tests).
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ResetAllOptionOccurrences">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9*/,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2146,
 FQN="llvm::cl::ResetAllOptionOccurrences", NM="_ZN4llvm2cl25ResetAllOptionOccurrencesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl25ResetAllOptionOccurrencesEv")
//</editor-fold>
public static void ResetAllOptionOccurrences() {
  GlobalParser.$arrow().ResetAllOptionOccurrences();
  resetAllOptionsPre39();
}


/// \brief Reset the command line parser back to its initial state.  This
/// removes
/// all options, categories, and subcommands and returns the parser to a state
/// where no options are supported.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::ResetCommandLineParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2145,
 FQN="llvm::cl::ResetCommandLineParser", NM="_ZN4llvm2cl22ResetCommandLineParserEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl22ResetCommandLineParserEv")
//</editor-fold>
public static void ResetCommandLineParser() {
  GlobalParser.$arrow().reset();
}


// Initialise the general option category.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::GeneralCategory">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 360,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 237,
 FQN="llvm::cl::GeneralCategory", NM="_ZN4llvm2cl15GeneralCategoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl15GeneralCategoryE")
//</editor-fold>
public static final OptionCategory GeneralCategory/*J*/= new OptionCategory("General options");

// A special subcommand representing no subcommand
//<editor-fold defaultstate="collapsed" desc="llvm::cl::TopLevelSubCommand">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 367,
 FQN="llvm::cl::TopLevelSubCommand", NM="_ZN4llvm2cl18TopLevelSubCommandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl18TopLevelSubCommandE")
//</editor-fold>
public static final ManagedStatic<SubCommand> TopLevelSubCommand/*J*/ = new ManagedStatic<SubCommand>(new ManagedStaticInfoImpl<SubCommand>(){
    @Override
    protected SubCommand create() {
      return new SubCommand();
    }
  });
  
// A special subcommand that can be used to put an option into all subcommands.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::AllSubCommands">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 370,
 FQN="llvm::cl::AllSubCommands", NM="_ZN4llvm2cl14AllSubCommandsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl14AllSubCommandsE")
//</editor-fold>
public static final ManagedStatic<SubCommand> AllSubCommands/*J*/= new ManagedStatic<SubCommand>(new ManagedStaticInfoImpl<SubCommand>(){
    @Override
    protected SubCommand create() {
      return new SubCommand();
    }
  });

public static initializer<Integer> init$Int(final /*const*/ int /*&*/ Val) {
  return new initializer<Integer>(Val);
}
public static initializer<Boolean> init$Bool(final /*const*/ boolean /*&*/ Val) {
  return new initializer<Boolean>(Val);
}

public static final Object clEnumValEnd = null;

public static void java$shutdown() {
  CommandLineStatics.java$shutdown();
}

} // END OF class ClGlobals
