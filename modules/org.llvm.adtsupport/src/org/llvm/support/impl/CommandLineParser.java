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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.llvm.support.sys.*;
import static org.llvm.cl.ClGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 88,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 87,
 FQN="(anonymous namespace)::CommandLineParser", NM="_ZN12_GLOBAL__N_117CommandLineParserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParserE")
//</editor-fold>
public class CommandLineParser implements Destructors.ClassWithDestructor {
/*public:*/
  // Globals for name and overview of program.  Program name is not a string to
  // avoid static ctor/dtor issues.
  public std.string ProgramName;
  public /*const*/char$ptr/*char P*/ ProgramOverview;
  
  // This collects additional help to be printed.
  public vectorCharPtr MoreHelp;
  
  // This collects the different option categories that have been registered.
  public SmallPtrSet<OptionCategory /*P*/ > RegisteredOptionCategories;
  
  // This collects the different subcommands that have been registered.
  public SmallPtrSet<SubCommand /*P*/ > RegisteredSubCommands;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::CommandLineParser">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 104,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 106,
   FQN="(anonymous namespace)::CommandLineParser::CommandLineParser", NM="_ZN12_GLOBAL__N_117CommandLineParserC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParserC1Ev")
  //</editor-fold>
  public CommandLineParser() {
    // : ProgramName(), ProgramOverview(null), MoreHelp(), RegisteredOptionCategories(), RegisteredSubCommands(), ActiveSubCommand(null) 
    //START JInit
    this.ProgramName = new std.string();
    this.ProgramOverview = null;
    this.MoreHelp = new vectorCharPtr();
    this.RegisteredOptionCategories = new SmallPtrSet<OptionCategory /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this.RegisteredSubCommands = new SmallPtrSet<SubCommand /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.ActiveSubCommand = null;
    //END JInit
    registerSubCommand($AddrOf(ClGlobals.TopLevelSubCommand.$star()));
    registerSubCommand($AddrOf(ClGlobals.AllSubCommands.$star()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::ResetAllOptionOccurrences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 998,
   FQN="(anonymous namespace)::CommandLineParser::ResetAllOptionOccurrences", NM="_ZN12_GLOBAL__N_117CommandLineParser25ResetAllOptionOccurrencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser25ResetAllOptionOccurrencesEv")
  //</editor-fold>
  public void ResetAllOptionOccurrences() {
    // So that we can parse different command lines multiple times in succession
    // we reset all option values to look like they have never been seen before.
    for (SubCommand /*P*/ SC : RegisteredSubCommands) {
      for (final StringMapEntry<Option /*P*/ > /*&*/ O : SC.OptionsMap)  {
        O.second.reset();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::ParseCommandLineOptions">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1007,
   FQN="(anonymous namespace)::CommandLineParser::ParseCommandLineOptions", NM="_ZN12_GLOBAL__N_117CommandLineParser23ParseCommandLineOptionsEiPKPKcS2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser23ParseCommandLineOptionsEiPKPKcS2_b")
  //</editor-fold>
  public boolean ParseCommandLineOptions(int argc, 
                         /*const*/type$ptr<char$ptr>/*char P const P*/ argv, 
                         /*const*/char$ptr/*char P*/ Overview, 
                         boolean IgnoreErrors) {
    BumpPtrAllocatorImpl A = null;
    try {
      assert (hasOptions()) : "No options specified!";
      
      // Expand response files.
      SmallVector</*const*/char$ptr/*char P*//*,  20*/> newArgv/*J*/= new SmallVector</*const*/char$ptr/*char P*//*,  20*/>(JD$T.INSTANCE, 20, argv, argv.$add(argc), null);
      A/*J*/= new BumpPtrAllocatorImpl();
      StringSaver Saver/*J*/= new StringSaver(A);
      ExpandResponseFiles(Saver, /*FuncRef*/ClGlobals::TokenizeGNUCommandLine, newArgv);
      argv = $tryClone(newArgv.$at(0).$addr());
      argc = ((/*static_cast*/int)(newArgv.size()));
      
      // Copy the program name into ProgName, making sure not to overflow it.
      ProgramName.$assignMove(path.filename(new StringRef(argv.$at(0))).$string());
      
      ProgramOverview = $tryClone(Overview);
      bool$ref ErrorParsing = create_bool$ref(false);
      
      // Check out the positional arguments to collect information about them.
      /*uint*/int NumPositionalRequired = 0;
      
      // Determine whether or not there are an unlimited number of positionals
      boolean HasUnlimitedPositionals = false;
      
      int FirstArg = 1;
      SubCommand /*P*/ ChosenSubCommand = $AddrOf(TopLevelSubCommand.$star());
      if (argc >= 2 && argv.$at(FirstArg).$at(0) != $$MINUS) {
        // If the first argument specifies a valid subcommand, start processing
        // options from the second argument.
        ChosenSubCommand = LookupSubCommand(argv.$at(FirstArg));
        if (ChosenSubCommand != $AddrOf(TopLevelSubCommand.$star())) {
          FirstArg = 2;
        }
      }
      GlobalParser.$arrow().ActiveSubCommand = ChosenSubCommand;
      assert Native.$bool(ChosenSubCommand);
      final type$ref<Option /*P*/ /*&*/> ConsumeAfterOpt = create_type$ref(ChosenSubCommand.ConsumeAfterOpt);
      final SmallVector<Option /*P*//*, 4*/> /*&*/ PositionalOpts = ChosenSubCommand.PositionalOpts;
      final SmallVector<Option /*P*//*, 4*/> /*&*/ SinkOpts = ChosenSubCommand.SinkOpts;
      final StringMap<Option /*P*/ /*, MallocAllocator*/> /*&*/ OptionsMap = ChosenSubCommand.OptionsMap;
      if ((ConsumeAfterOpt.$deref() != null)) {
        assert ($greater_uint(PositionalOpts.size(), 0)) : "Cannot specify cl::ConsumeAfter without a positional argument!";
      }
      if (!PositionalOpts.empty()) {
        
        // Calculate how many positional values are _required_.
        boolean UnboundedFound = false;
        for (/*size_t*/int i = 0, e = PositionalOpts.size(); i != e; ++i) {
          Option /*P*/ Opt = PositionalOpts.$at(i);
          if (RequiresValue(Opt)) {
            ++NumPositionalRequired;
          } else if ((ConsumeAfterOpt.$deref() != null)) {
            // ConsumeAfter cannot be combined with "optional" positional options
            // unless there is only one positional argument...
            if ($greater_uint(PositionalOpts.size(), 1)) {
              if (!IgnoreErrors) {
                Opt.error(new Twine(/*KEEP_STR*/"error - this positional option will never be matched, because it does not Require a value, and a cl::ConsumeAfter option is active!"));
              }
              ErrorParsing.$set(true);
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
            ErrorParsing.$set(true);
          }
          UnboundedFound |= EatsUnboundedNumberOfValues(Opt);
        }
        HasUnlimitedPositionals = UnboundedFound || (ConsumeAfterOpt.$deref() != null);
      }
      
      // PositionalVals - A vector of "positional" arguments we accumulate into
      // the process at the end.
      //
      SmallVector<std.pairTypeUInt<StringRef>/*, 4*/> PositionalVals/*J*/= new SmallVector<std.pairTypeUInt<StringRef>/*, 4*/>(4, new std.pairTypeUInt(new StringRef(), 0));
      
      // If the program has named positional arguments, and the name has been run
      // across, keep track of which positional argument was named.  Otherwise put
      // the positional args into the PositionalVals list...
      Option /*P*/ ActivePositionalArg = null;
      
      // Loop over all of the arguments... processing them.
      boolean DashDashFound = false; // Have we read '--'?
      for (int$ref i = create_int$ref(FirstArg); i.$deref() < argc; i.$set$preInc()) {
        Option /*P*/ Handler = null;
        Option /*P*/ NearestHandler = null;
        std.string NearestHandlerString/*J*/= new std.string();
        StringRef Value/*J*/= new StringRef();
        StringRef ArgName = new StringRef(/*KEEP_STR*/$EMPTY);
        
        // Check to see if this is a positional argument.  This argument is
        // considered to be positional if it doesn't start with '-', if it is "-"
        // itself, or if we have seen "--" already.
        //
        if (argv.$at(i.$deref()).$at(0) != $$MINUS || argv.$at(i.$deref()).$at(1) == 0 || DashDashFound) {
          // Positional argument!
          if ((ActivePositionalArg != null)) {
            ProvidePositionalOption(ActivePositionalArg, new StringRef(argv.$at(i.$deref())), i.$deref());
            continue; // We are done!
          }
          if (!PositionalOpts.empty()) {
            PositionalVals.push_back(new std.pairTypeUInt<StringRef>(new StringRef(argv.$at(i.$deref())),i.$deref()));
            
            // All of the positional arguments have been fulfulled, give the rest to
            // the consume after option... if it's specified...
            //
            if ($greatereq_uint(PositionalVals.size(), NumPositionalRequired) && (ConsumeAfterOpt.$deref() != null)) {
              for (i.$set$preInc(); i.$deref() < argc; i.$set$preInc())  {
                PositionalVals.push_back(new std.pairTypeUInt<StringRef>(new StringRef(argv.$at(i.$deref())),i.$deref()));
              }
              break; // Handle outside of the argument processing loop...
            }
            
            // Delay processing positional arguments until the end...
            continue;
          }
        } else if (argv.$at(i.$deref()).$at(0) == $$MINUS && argv.$at(i.$deref()).$at(1) == $$MINUS && argv.$at(i.$deref()).$at(2) == 0
           && !DashDashFound) {
          DashDashFound = true; // This is the mythical "--"?
          continue; // Don't try to process it as an argument itself.
        } else if ((ActivePositionalArg != null)
           && ((ActivePositionalArg.getMiscFlags() & MiscFlags.PositionalEatsArgs) != 0)) {
          // If there is a positional argument eating options, check to see if this
          // option is another positional argument.  If so, treat it as an argument,
          // otherwise feed it to the eating positional.
          ArgName.$assignMove(/*STRINGREF_STR*/argv.$at(i.$deref()).$add(1));
          // Eat leading dashes.
          while (!ArgName.empty() && ArgName.$at(0) == $$MINUS) {
            ArgName.$assignMove(ArgName.substr(1));
          }
          
          Handler = LookupOption($Deref(ChosenSubCommand), ArgName, Value);
          if (!(Handler != null) || Handler.getFormattingFlag() != FormattingFlags.Positional) {
            ProvidePositionalOption(ActivePositionalArg, new StringRef(argv.$at(i.$deref())), i.$deref());
            continue; // We are done!
          }
        } else { // We start with a '-', must be an argument.
          ArgName.$assignMove(/*STRINGREF_STR*/argv.$at(i.$deref()).$add(1));
          // Eat leading dashes.
          while (!ArgName.empty() && ArgName.$at(0) == $$MINUS) {
            ArgName.$assignMove(ArgName.substr(1));
          }
          
          Handler = LookupOption($Deref(ChosenSubCommand), ArgName, Value);
          
          // Check to see if this "option" is really a prefixed or grouped argument.
          if (!(Handler != null)) {
            Handler = HandlePrefixedOrGroupedOption(ArgName, Value, ErrorParsing, 
                OptionsMap);
          }
          
          // Otherwise, look for the closest available option to report to the user
          // in the upcoming error.
          if (!(Handler != null) && SinkOpts.empty()) {
            NearestHandler
               = LookupNearestOption(new StringRef(ArgName), OptionsMap, NearestHandlerString);
          }
        }
        if (!(Handler != null)) {
          if (SinkOpts.empty()) {
            if (!IgnoreErrors) {
              errs().$out(ProgramName).$out(/*KEEP_STR*/": Unknown command line argument '").$out(
                  argv.$at(i.$deref())
              ).$out(/*KEEP_STR*/"'.  Try: '").$out(argv.$at(0)).$out(/*KEEP_STR*/" -help'\n");
              if ((NearestHandler != null)) {
                // If we know a near match, report it as well.
                errs().$out(ProgramName).$out(/*KEEP_STR*/": Did you mean '-").$out(NearestHandlerString).$out(
                    /*KEEP_STR*/"'?\n"
                );
              }
            }
            
            ErrorParsing.$set(true);
          } else {
            for (type$ptr<Option /*P*/ > I = $tryClone(SinkOpts.begin()), 
                /*P*/ E = $tryClone(SinkOpts.end());
                 $noteq_ptr(I, E); I.$preInc())  {
              (I.$star()).addOccurrence(i.$deref(), new StringRef(/*KEEP_STR*/$EMPTY), new StringRef(argv.$at(i.$deref())));
            }
          }
          continue;
        }
        
        // If this is a named positional argument, just remember that it is the
        // active one...
        if (Handler.getFormattingFlag() == FormattingFlags.Positional) {
          ActivePositionalArg = Handler;
        } else {
          ErrorParsing.$set$orassign(ProvideOption(Handler, new StringRef(ArgName), new StringRef(Value), argc, argv, i));
        }
      }
      
      // Check and handle positional arguments now...
      if ($greater_uint(NumPositionalRequired, PositionalVals.size())) {
        if (!IgnoreErrors) {
          errs().$out(ProgramName).$out(
              /*KEEP_STR*/": Not enough positional command line arguments specified!\n"
          ).$out(
              /*KEEP_STR*/"Must specify at least "
          ).$out_uint(NumPositionalRequired).$out(
              /*KEEP_STR*/" positional arguments: See: "
          ).$out(argv.$at(0)).$out(/*KEEP_STR*/" -help\n");
        }
        
        ErrorParsing.$set(true);
      } else if (!HasUnlimitedPositionals
         && $greater_uint(PositionalVals.size(), PositionalOpts.size())) {
        if (!IgnoreErrors) {
          errs().$out(ProgramName).$out(/*KEEP_STR*/": Too many positional arguments specified!\n").$out(
              /*KEEP_STR*/"Can specify at most "
          ).$out_uint(PositionalOpts.size()).$out(
              /*KEEP_STR*/" positional arguments: See: "
          ).$out(argv.$at(0)).$out(/*KEEP_STR*/" -help\n");
        }
        ErrorParsing.$set(true);
      } else if (!(ConsumeAfterOpt.$deref() != null)) {
        // Positional args have already been handled if ConsumeAfter is specified.
        /*uint*/int ValNo = 0;
        /*uint*/int NumVals = ((/*static_cast*//*uint*/int)(PositionalVals.size()));
        for (/*size_t*/int i = 0, e = PositionalOpts.size(); i != e; ++i) {
          if (RequiresValue(PositionalOpts.$at(i))) {
            ProvidePositionalOption(PositionalOpts.$at(i), new StringRef(PositionalVals.$at(ValNo).first), 
                PositionalVals.$at(ValNo).second);
            ValNo++;
            --NumPositionalRequired; // We fulfilled our duty...
          }
          
          // If we _can_ give this option more arguments, do so now, as long as we
          // do not give it values that others need.  'Done' controls whether the
          // option even _WANTS_ any more.
          //
          boolean Done = PositionalOpts.$at(i).getNumOccurrencesFlag() == NumOccurrencesFlag.Required;
          while ($greater_uint(NumVals - ValNo, NumPositionalRequired) && !Done) {
            switch (PositionalOpts.$at(i).getNumOccurrencesFlag()) {
             case Optional:
              Done = true; // Optional arguments want _at most_ one value
             case ZeroOrMore: // Zero or more will take all they can get...
             case OneOrMore: // One or more will take all they can get...
              ProvidePositionalOption(PositionalOpts.$at(i), 
                  new StringRef(PositionalVals.$at(ValNo).first), 
                  PositionalVals.$at(ValNo).second);
              ValNo++;
              break;
             default:
              throw new llvm_unreachable("Internal error, unexpected NumOccurrences flag in positional argument processing!");
            }
          }
        }
      } else {
        assert ((ConsumeAfterOpt.$deref() != null) && $lesseq_uint(NumPositionalRequired, PositionalVals.size()));
        /*uint*/int ValNo = 0;
        for (/*size_t*/int j = 1, e = PositionalOpts.size(); j != e; ++j)  {
          if (RequiresValue(PositionalOpts.$at(j))) {
            ErrorParsing.$set$orassign(ProvidePositionalOption(PositionalOpts.$at(j), 
                new StringRef(PositionalVals.$at(ValNo).first), 
                PositionalVals.$at(ValNo).second));
            ValNo++;
          }
        }
        
        // Handle the case where there is just one positional option, and it's
        // optional.  In this case, we want to give JUST THE FIRST option to the
        // positional option and keep the rest for the consume after.  The above
        // loop would have assigned no values to positional options in this case.
        //
        if (PositionalOpts.size() == 1 && ValNo == 0 && !PositionalVals.empty()) {
          ErrorParsing.$set$orassign(ProvidePositionalOption(PositionalOpts.$at(0), 
              new StringRef(PositionalVals.$at(ValNo).first), 
              PositionalVals.$at(ValNo).second));
          ValNo++;
        }
        
        // Handle over all of the rest of the arguments to the
        // cl::ConsumeAfter command line option...
        for (; ValNo != PositionalVals.size(); ++ValNo)  {
          ErrorParsing.$set$orassign(ProvidePositionalOption(ConsumeAfterOpt.$deref(), new StringRef(PositionalVals.$at(ValNo).first), 
              PositionalVals.$at(ValNo).second));
        }
      }
      
      // Loop over args and make sure all required args are specified!
      for (final /*const*/ StringMapEntry<Option /*P*/ > /*&*/ Opt : OptionsMap) {
        switch (Opt.second.getNumOccurrencesFlag()) {
         case Required:
         case OneOrMore:
          if (Opt.second.getNumOccurrences() == 0) {
            Opt.second.error(new Twine(/*KEEP_STR*/"must be specified at least once!"));
            ErrorParsing.$set(true);
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
        if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType(/*KEEP_STR*/"commandline")) {
          dbgs().$out(/*KEEP_STR*/"Args: ");
          for (int i = 0; i < argc; ++i)  {
            dbgs().$out(argv.$at(i)).$out_char($$SPACE);
          }
          dbgs().$out_char($$LF);
          ;
        }
      } while (false);
      
      // Free all of the memory allocated to the map.  Command line options may only
      // be processed once!
      MoreHelp.clear();
      
      // If we had an error processing our arguments, don't let the program execute
      if (ErrorParsing.$deref()) {
        if (!IgnoreErrors) {
          exit(1);
        }
        return false;
      }
      return true;
    } finally {
      if (A != null) { A.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::addLiteralOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 114,
   FQN="(anonymous namespace)::CommandLineParser::addLiteralOption", NM="_ZN12_GLOBAL__N_117CommandLineParser16addLiteralOptionERN4llvm2cl6OptionEPNS2_10SubCommandEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser16addLiteralOptionERN4llvm2cl6OptionEPNS2_10SubCommandEPKc")
  //</editor-fold>
  public void addLiteralOption(final Option /*&*/ Opt, SubCommand /*P*/ SC, /*const*/char$ptr/*char P*/ Name) {
    if (Opt.hasArgStr()) {
      return;
    }
    if (!SC.OptionsMap.insert(new std.pairTypePtr<StringRef, Option /*P*/ >( 
            JD$Pair$_U1$_U2.INSTANCE, (p)->new StringRef(((std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >) p).first), 
            (p)->(Option /*P*/ ) ((std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >) p).second, std.make_pair_T_Ptr(Name, $AddrOf(Opt)))).second) {
      errs().$out(ProgramName).$out(/*KEEP_STR*/": CommandLine Error: Option '").$out(Name).$out(
          /*KEEP_STR*/"' registered more than once!\n"
      );
      report_fatal_error($("inconsistency in registered CommandLine options"));
    }
    
    // If we're adding this to all sub-commands, add it to the ones that have
    // already been registered.
    if (SC == $AddrOf(AllSubCommands.$star())) {
      for (final SubCommand /*P*/ /*const*/ /*&*/ Sub : RegisteredSubCommands) {
        if (SC == Sub) {
          continue;
        }
        addLiteralOption(Opt, Sub, Name);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::addLiteralOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 134,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 111,
   FQN="(anonymous namespace)::CommandLineParser::addLiteralOption", NM="_ZN12_GLOBAL__N_117CommandLineParser16addLiteralOptionERN4llvm2cl6OptionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser16addLiteralOptionERN4llvm2cl6OptionEPKc")
  //</editor-fold>
  public void addLiteralOption(final Option /*&*/ Opt, /*const*/char$ptr/*char P*/ Name) {
    if (Opt.Subs.empty()) {
      addLiteralOption(Opt, $AddrOf(TopLevelSubCommand.$star()), Name);
    } else {
      for (SubCommand /*P*/ SC : Opt.Subs)  {
        addLiteralOption(Opt, SC, Name);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::addOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 143,
   FQN="(anonymous namespace)::CommandLineParser::addOption", NM="_ZN12_GLOBAL__N_117CommandLineParser9addOptionEPN4llvm2cl6OptionEPNS2_10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser9addOptionEPN4llvm2cl6OptionEPNS2_10SubCommandE")
  //</editor-fold>
  public void addOption(Option /*P*/ O, SubCommand /*P*/ SC) {
    boolean HadErrors = false;
    if (O.hasArgStr()) {
      // Add argument to the argument map!
      if (!SC.OptionsMap.insert(std.make_pair_T_Ptr(new StringRef(O.ArgStr), O)).second) {
        errs().$out(ProgramName).$out(/*KEEP_STR*/": CommandLine Error: Option '").$out(/*NO_COPY*/O.ArgStr).$out(
            /*KEEP_STR*/"' registered more than once!\n"
        );
        HadErrors = true;
      }
    }
    
    // Remember information about positional options.
    if (O.getFormattingFlag() == FormattingFlags.Positional) {
      SC.PositionalOpts.push_back(O);
    } else if (((O.getMiscFlags() & MiscFlags.Sink) != 0)) { // Remember sink options
      SC.SinkOpts.push_back(O);
    } else if (O.getNumOccurrencesFlag() == NumOccurrencesFlag.ConsumeAfter) {
      if ((SC.ConsumeAfterOpt != null)) {
        O.error(new Twine(/*KEEP_STR*/"Cannot specify more than one option with cl::ConsumeAfter!"));
        HadErrors = true;
      }
      SC.ConsumeAfterOpt = O;
    }
    
    // Fail hard if there were errors. These are strictly unrecoverable and
    // indicate serious issues such as conflicting option names or an
    // incorrectly
    // linked LLVM distribution.
    if (HadErrors) {
      report_fatal_error($("inconsistency in registered CommandLine options"));
    }
    
    // If we're adding this to all sub-commands, add it to the ones that have
    // already been registered.
    if (SC == $AddrOf(AllSubCommands.$star())) {
      for (final SubCommand /*P*/ /*const*/ /*&*/ Sub : RegisteredSubCommands) {
        if (SC == Sub) {
          continue;
        }
        addOption(O, Sub);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::addOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9 logic is kept for now*/,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 185,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 121,
   FQN="(anonymous namespace)::CommandLineParser::addOption", NM="_ZN12_GLOBAL__N_117CommandLineParser9addOptionEPN4llvm2cl6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser9addOptionEPN4llvm2cl6OptionE")
  //</editor-fold>
  public void addOption(Option /*P*/ O) {
//    // JAVA: from old days...
//    assert (O.NextRegistered == null) : "argument multiply registered!";
//    
//    O.NextRegistered = RegisteredOptionList;
//    RegisteredOptionList = O;
//    MarkOptionsChanged();
//    ////////////////////////////////////////////////////////////////
    
    if (O.Subs.empty()) {
      addOption(O, $AddrOf(TopLevelSubCommand.$star()));
    } else {
      for (SubCommand /*P*/ SC : O.Subs)  {
        addOption(O, SC);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::removeOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 194,
   FQN="(anonymous namespace)::CommandLineParser::removeOption", NM="_ZN12_GLOBAL__N_117CommandLineParser12removeOptionEPN4llvm2cl6OptionEPNS2_10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser12removeOptionEPN4llvm2cl6OptionEPNS2_10SubCommandE")
  //</editor-fold>
  public void removeOption(Option /*P*/ O, SubCommand /*P*/ SC) {
    SmallVector<StringRef> OptionNames/*J*/= new SmallVector<StringRef>(16, new StringRef());
    O.getExtraOptionNames(OptionNames);
    if (O.hasArgStr()) {
      OptionNames.push_back(O.ArgStr);
    }
    
    final SubCommand /*&*/ Sub = $Deref(SC);
    for (StringRef Name : OptionNames)  {
      Sub.OptionsMap.erase(/*NO_COPY*/(Name));
    }
    if (O.getFormattingFlag() == FormattingFlags.Positional) {
      for (type$ptr<Option /*P*/ /*P*/> Opt = $tryClone(Sub.PositionalOpts.begin());
           $noteq_ptr(Opt, Sub.PositionalOpts.end()); Opt.$preInc()) {
        if (Opt.$star() == O) {
          Sub.PositionalOpts.erase(Opt);
          break;
        }
      }
    } else if (((O.getMiscFlags() & MiscFlags.Sink) != 0)) {
      for (type$ptr<Option /*P*/ /*P*/> Opt = $tryClone(Sub.SinkOpts.begin()); $noteq_ptr(Opt, Sub.SinkOpts.end()); Opt.$preInc()) {
        if (Opt.$star() == O) {
          Sub.SinkOpts.erase(Opt);
          break;
        }
      }
    } else if (O == Sub.ConsumeAfterOpt) {
      Sub.ConsumeAfterOpt = null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::removeOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9 logic is kept for now*/,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 223,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 153,
   FQN="(anonymous namespace)::CommandLineParser::removeOption", NM="_ZN12_GLOBAL__N_117CommandLineParser12removeOptionEPN4llvm2cl6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser12removeOptionEPN4llvm2cl6OptionE")
  //</editor-fold>
  public void removeOption(Option /*P*/ O) {
//    // JAVA: RegisteredOptionList for now from old days
//    Option Prev = null;
//    for(Option Opt = RegisteredOptionList; Opt != null; Opt = RegisteredOptionList.NextRegistered) {
//      if (Opt == O) {
//        if (Prev != null) {
//          Prev.NextRegistered = O.NextRegistered;
//        } else {
//          assert RegisteredOptionList == O;
//          RegisteredOptionList = O.NextRegistered;
//        }
//        break;
//      }
//      Prev = Opt;
//    }
//    ///////////////////////////////////////////////////////////
    if (O.Subs.empty()) {
      removeOption(O, $AddrOf(TopLevelSubCommand.$star()));
    } else {
      if (O.isInAllSubCommands()) {
        for (SubCommand /*P*/ SC : RegisteredSubCommands)  {
          removeOption(O, SC);
        }
      } else {
        for (SubCommand /*P*/ SC : O.Subs)  {
          removeOption(O, SC);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::hasOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 237,
   FQN="(anonymous namespace)::CommandLineParser::hasOptions", NM="_ZNK12_GLOBAL__N_117CommandLineParser10hasOptionsERKN4llvm2cl10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK12_GLOBAL__N_117CommandLineParser10hasOptionsERKN4llvm2cl10SubCommandE")
  //</editor-fold>
  public boolean hasOptions(final /*const*/ SubCommand /*&*/ Sub) /*const*/ {
    return (!Sub.OptionsMap.empty() || !Sub.PositionalOpts.empty()
       || null != Sub.ConsumeAfterOpt);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::hasOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 242,
   FQN="(anonymous namespace)::CommandLineParser::hasOptions", NM="_ZNK12_GLOBAL__N_117CommandLineParser10hasOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK12_GLOBAL__N_117CommandLineParser10hasOptionsEv")
  //</editor-fold>
  public boolean hasOptions() /*const*/ {
    for (final SubCommand /*P*/ /*const*/ /*&*/ S : RegisteredSubCommands) {
      if (hasOptions($Deref(S))) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::getActiveSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 250,
   FQN="(anonymous namespace)::CommandLineParser::getActiveSubCommand", NM="_ZN12_GLOBAL__N_117CommandLineParser19getActiveSubCommandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser19getActiveSubCommandEv")
  //</editor-fold>
  public SubCommand /*P*/ getActiveSubCommand() {
    return ActiveSubCommand;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::updateArgStr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 252,
   FQN="(anonymous namespace)::CommandLineParser::updateArgStr", NM="_ZN12_GLOBAL__N_117CommandLineParser12updateArgStrEPN4llvm2cl6OptionENS1_9StringRefEPNS2_10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser12updateArgStrEPN4llvm2cl6OptionENS1_9StringRefEPNS2_10SubCommandE")
  //</editor-fold>
  public void updateArgStr(Option /*P*/ O, StringRef NewName, SubCommand /*P*/ SC) {
    final SubCommand /*&*/ Sub = $Deref(SC);
    if (!Sub.OptionsMap.insert(std.make_pair_T_Ptr(NewName, O)).second) {
      errs().$out(ProgramName).$out(/*KEEP_STR*/": CommandLine Error: Option '").$out(/*NO_COPY*/O.ArgStr).$out(
          /*KEEP_STR*/"' registered more than once!\n"
      );
      report_fatal_error($("inconsistency in registered CommandLine options"));
    }
    Sub.OptionsMap.erase(/*NO_COPY*/new StringRef(O.ArgStr));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::updateArgStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 262,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 185,
   FQN="(anonymous namespace)::CommandLineParser::updateArgStr", NM="_ZN12_GLOBAL__N_117CommandLineParser12updateArgStrEPN4llvm2cl6OptionENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser12updateArgStrEPN4llvm2cl6OptionENS1_9StringRefE")
  //</editor-fold>
  public void updateArgStr(Option /*P*/ O, StringRef NewName) {
    if (O.Subs.empty()) {
      updateArgStr(O, new StringRef(NewName), $AddrOf(TopLevelSubCommand.$star()));
    } else {
      for (SubCommand /*P*/ SC : O.Subs)  {
        updateArgStr(O, new StringRef(NewName), SC);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::printOptionValues">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2004,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1715,
   FQN="(anonymous namespace)::CommandLineParser::printOptionValues", NM="_ZN12_GLOBAL__N_117CommandLineParser17printOptionValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser17printOptionValuesEv")
  //</editor-fold>
  public void printOptionValues() {
    if (!PrintOptions.$T() && !PrintAllOptions.$T()) {
      return;
    }
    
    SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >> Opts/*J*/= new SmallVector<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >>(128, new std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >());
    sortOpts(ActiveSubCommand.OptionsMap, Opts, /*ShowHidden*/ true);
    
    // Compute the maximum argument length...
    /*size_t*/int MaxArgLen = 0;
    for (/*size_t*/int i = 0, e = Opts.size(); i != e; ++i)  {
      MaxArgLen = std.max(MaxArgLen, Opts.$at(i).second.getOptionWidth());
    }
    
    for (/*size_t*/int i = 0, e = Opts.size(); i != e; ++i)  {
      Opts.$at(i).second.printOptionValue(MaxArgLen, PrintAllOptions.$T());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::registerCategory">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 273,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 196,
   FQN="(anonymous namespace)::CommandLineParser::registerCategory", NM="_ZN12_GLOBAL__N_117CommandLineParser16registerCategoryEPN4llvm2cl14OptionCategoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser16registerCategoryEPN4llvm2cl14OptionCategoryE")
  //</editor-fold>
  public void registerCategory(OptionCategory /*P*/ cat) {
    OptionCategory /*P*/ L$cat = cat;
    assert (AdtsupportLlvmGlobals.count_if(RegisteredOptionCategories, /*[=L$cat(cat)]*/ (/*const*/ OptionCategory /*P*/ Category) -> {
          return $eq_ptr(L$cat.getName(), Category.getName());
        }) == 0) : "Duplicate option categories";
    
    RegisteredOptionCategories.insert(cat);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::registerSubCommand">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 283,
   FQN="(anonymous namespace)::CommandLineParser::registerSubCommand", NM="_ZN12_GLOBAL__N_117CommandLineParser18registerSubCommandEPN4llvm2cl10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser18registerSubCommandEPN4llvm2cl10SubCommandE")
  //</editor-fold>
  public void registerSubCommand(SubCommand /*P*/ sub) {
    SubCommand /*P*/ L$sub = sub;
    assert (AdtsupportLlvmGlobals.count_if(RegisteredSubCommands, /*[=L$sub(sub)]*/ (/*const*/ SubCommand /*P*/ Sub) -> {
          return ($noteq_ptr(L$sub.getName(), (/*const*/char$ptr/*char P*/ )null)) && ($eq_ptr(Sub.getName(), L$sub.getName()));
        }) == 0) : "Duplicate subcommands";
    RegisteredSubCommands.insert(sub);
    
    // For all options that have been registered for all subcommands, add the
    // option to this subcommand now.
    if (sub != $AddrOf(AllSubCommands.$star())) {
      for (final StringMapEntry<Option /*P*/ > /*&*/ E : AllSubCommands.$arrow().OptionsMap) {
        Option /*P*/ O = E.second;
        if ((O.isPositional() || O.isSink() || O.isConsumeAfter())
           || O.hasArgStr()) {
          addOption(O, sub);
        } else {
          addLiteralOption($Deref(O), sub, E.first().str().c_str());
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::unregisterSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 306,
   FQN="(anonymous namespace)::CommandLineParser::unregisterSubCommand", NM="_ZN12_GLOBAL__N_117CommandLineParser20unregisterSubCommandEPN4llvm2cl10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser20unregisterSubCommandEPN4llvm2cl10SubCommandE")
  //</editor-fold>
  public void unregisterSubCommand(SubCommand /*P*/ sub) {
    RegisteredSubCommands.erase(sub);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 310,
   FQN="(anonymous namespace)::CommandLineParser::reset", NM="_ZN12_GLOBAL__N_117CommandLineParser5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser5resetEv")
  //</editor-fold>
  public void reset() {
    ActiveSubCommand = null;
    ProgramName.clear();
    ProgramOverview = null;
    
    MoreHelp.clear();
    RegisteredOptionCategories.clear();
    
    ResetAllOptionOccurrences();
    RegisteredSubCommands.clear();
    
    TopLevelSubCommand.$arrow().reset();
    AllSubCommands.$arrow().reset();
    registerSubCommand($AddrOf(TopLevelSubCommand.$star()));
    registerSubCommand($AddrOf(AllSubCommands.$star()));
  }

/*private:*/
  private SubCommand /*P*/ ActiveSubCommand;
  
  
  //===----------------------------------------------------------------------===//
  // Basic, shared command line option processing machinery.
  //
  
  /// LookupOption - Lookup the option specified by the specified option on the
  /// command line.  If there is a value specified (after an equal sign) return
  /// that as well.  This assumes that leading dashes have already been stripped.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::LookupOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 399,
   FQN="(anonymous namespace)::CommandLineParser::LookupOption", NM="_ZN12_GLOBAL__N_117CommandLineParser12LookupOptionERN4llvm2cl10SubCommandERNS1_9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser12LookupOptionERN4llvm2cl10SubCommandERNS1_9StringRefES6_")
  //</editor-fold>
  private Option /*P*/ LookupOption(final SubCommand /*&*/ Sub, final StringRef /*&*/ Arg, 
              final StringRef /*&*/ Value) {
    // Reject all dashes.
    if (Arg.empty()) {
      return null;
    }
    assert ($AddrOf(Sub) != $AddrOf(AllSubCommands.$star()));
    
    /*size_t*/int EqualPos = Arg.find($$EQ);
    
    // If we have an equals sign, remember the value.
    if (EqualPos == StringRef.npos) {
      // Look up the option.
      StringMapIterator<Option /*P*/ > I = Sub.OptionsMap.find(/*NO_COPY*/Arg);
      if (I.$eq(Sub.OptionsMap.end())) {
        return null;
      }
      
      return I.$noteq(Sub.OptionsMap.end()) ? I.$arrow().second : null;
    }
    
    // If the argument before the = is a valid option name, we match.  If not,
    // return Arg unmolested.
    StringMapIterator<Option /*P*/ > I = Sub.OptionsMap.find(Arg.substr(0, EqualPos));
    if (I.$eq(Sub.OptionsMap.end())) {
      return null;
    }
    
    Value.$assignMove(Arg.substr(EqualPos + 1));
    Arg.$assignMove(Arg.substr(0, EqualPos));
    return I.$arrow().second;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::LookupSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 429,
   FQN="(anonymous namespace)::CommandLineParser::LookupSubCommand", NM="_ZN12_GLOBAL__N_117CommandLineParser16LookupSubCommandEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParser16LookupSubCommandEPKc")
  //</editor-fold>
  private SubCommand /*P*/ LookupSubCommand(/*const*/char$ptr/*char P*/ Name) {
    if ($eq_ptr(Name, null)) {
      return $AddrOf(TopLevelSubCommand.$star());
    }
    for (SubCommand /*P*/ S : RegisteredSubCommands) {
      if (S == $AddrOf(AllSubCommands.$star())) {
        continue;
      }
      if ($eq_ptr(S.getName(), null)) {
        continue;
      }
      if ($eq_StringRef(/*STRINGREF_STR*/S.getName(), /*STRINGREF_STR*/Name)) {
        return S;
      }
    }
    return $AddrOf(TopLevelSubCommand.$star());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CommandLineParser::~CommandLineParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 88,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 87,
   FQN="(anonymous namespace)::CommandLineParser::~CommandLineParser", NM="_ZN12_GLOBAL__N_117CommandLineParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN12_GLOBAL__N_117CommandLineParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    RegisteredSubCommands.$destroy();
    RegisteredOptionCategories.$destroy();
    MoreHelp.$destroy();
    ProgramName.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ProgramName=" + ProgramName // NOI18N
              + ", ProgramOverview=" + ProgramOverview // NOI18N
              + ", MoreHelp=" + MoreHelp // NOI18N
              + ", RegisteredOptionCategories=" + RegisteredOptionCategories // NOI18N
              + ", RegisteredSubCommands=" + RegisteredSubCommands // NOI18N
              + ", ActiveSubCommand=" + ActiveSubCommand; // NOI18N
  }
}
